package com.example.dapindao.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.AlertAdapter;
import com.example.dapindao.Adapter.FilmCriticsAdapter;
import com.example.dapindao.Adapter.HotListAdapter;
import com.example.dapindao.Adapter.LargeWatchAdapter;
import com.example.dapindao.Interface.AlertsInterface;
import com.example.dapindao.Interface.HotListInterface;
import com.example.dapindao.View.AlertsFragment;
import com.example.dapindao.View.FilmCriticsFragment;
import com.example.dapindao.View.LargeWatchFragment;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LargeWatchPresenter implements AlertsInterface.Presenter{
    private AlertsInterface.View view;
    private  RecyclerViewEmptySupport recyclerView;
    private LargeWatchAdapter adapter;
    private Context context;
    public LargeWatchPresenter(Context context, AlertsInterface.View view, LargeWatchAdapter adapter, RecyclerViewEmptySupport recyclerViewEmptySupport){
        this.context = context;
        this.adapter = adapter;
        this.recyclerView = recyclerViewEmptySupport;
        this.view = view;
    }


    @Override
    public void recFront(int type, int pageNum, int pageSize) {
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).recFront(type,0,0);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    try {
                        String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            JsonObject object = jsonObject.get("result").getAsJsonObject();
                            JsonArray jsonElements = object.getAsJsonArray("rows");
                            adapter = new LargeWatchAdapter(context,jsonElements);
                            recyclerView.setAdapter(adapter);
                            int total = object.get("total").getAsInt();
                            int totalPage = object.get("totalPage").getAsInt();
                            if(total != 0){
                                view.onRefresh();
                            }else {
                                // publicCue.loadAdapter(beanList);
                                view.failed();
                            }
                            if(totalPage>pageNum){
                                jsonElements.addAll(jsonElements);
                                view.onLoadMore();
                            }else {
                                view.onNothingData();
                            }

                        }else {
                            Toast.makeText(context,jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
