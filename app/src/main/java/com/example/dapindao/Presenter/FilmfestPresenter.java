package com.example.dapindao.Presenter;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.AdvertisingAdapter;
import com.example.dapindao.Adapter.AlertAdapter;
import com.example.dapindao.Adapter.BoxofficeAdapter;
import com.example.dapindao.Adapter.CompanyAdapter;
import com.example.dapindao.Adapter.DerivativesAdapter;
import com.example.dapindao.Adapter.FilmCriticsAdapter;
import com.example.dapindao.Adapter.FilmfestAdapter;
import com.example.dapindao.Adapter.HotListAdapter;
import com.example.dapindao.Adapter.LargeWatchAdapter;
import com.example.dapindao.Adapter.OverseasAdapter;
import com.example.dapindao.Adapter.SeriesAdapter;
import com.example.dapindao.Adapter.ShadowCastAdapter;
import com.example.dapindao.Adapter.WorkplaceAdapter;
import com.example.dapindao.Interface.AlertsInterface;
import com.example.dapindao.Interface.HotListInterface;
import com.example.dapindao.View.AdvertisingFragment;
import com.example.dapindao.View.AlertsFragment;
import com.example.dapindao.View.ArticleDetailsActivity;
import com.example.dapindao.View.BoxofficeFragment;
import com.example.dapindao.View.CompanyFragment;
import com.example.dapindao.View.DerivativesFragment;
import com.example.dapindao.View.FilmCriticsFragment;
import com.example.dapindao.View.FilmfestFragment;
import com.example.dapindao.View.LargeWatchFragment;
import com.example.dapindao.View.MovieFragment;
import com.example.dapindao.View.OverseasFragment;
import com.example.dapindao.View.SeriesFragment;
import com.example.dapindao.View.ShadowCastFragment;
import com.example.dapindao.View.WorkplaceFragmnet;
import com.example.dapindao.retrofit.HttpHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmfestPresenter implements AlertsInterface.Presenter{
    private FilmfestFragment fragment;
    private AlertsInterface.View view;
    JsonArray jsonElements;
    public FilmfestPresenter(FilmfestFragment fragment,AlertsInterface.View view){
        this.fragment = fragment;
        this.view = view;

    }


    @Override
    public void recFront(int type, int pageNum, int pageSize) {
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).recFront(type,pageNum,pageSize);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    try {
                        String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            JsonObject object = jsonObject.get("result").getAsJsonObject();
                            jsonElements = object.getAsJsonArray("rows");
                            fragment.adapter = new FilmfestAdapter(fragment.getContext(),jsonElements);
                            fragment.recyclerView.setAdapter(fragment.adapter);
                            fragment.adapter.setOnitemClickListener(new FilmfestAdapter.OnitemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    JsonObject objects =jsonElements.get(position).getAsJsonObject();
                                    Intent intent = new Intent(fragment.getContext(), ArticleDetailsActivity.class);
                                    intent.putExtra("articleId",objects.get("id").getAsString());
                                    fragment.startActivity(intent);
                                }
                            });
                            int total = object.get("total").getAsInt();
                            int totalPage = object.get("totalPage").getAsInt();
                            if(total != 0){
                                view.onRefresh();
                            }else {
                                // publicCue.loadAdapter(beanList);
                                view.failed();
                            }
                            if(pageNum>totalPage){
                                jsonElements.add(object.getAsJsonArray("rows"));
                                view.onLoadMore();

                            }else {
                                view.onNothingData();
                            }



                        }else {
                            Toast.makeText(fragment.getContext(),jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(fragment.getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
