package com.example.dapindao.Presenter;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.MysubscriptionAdapter;
import com.example.dapindao.Adapter.ShadowCastAdapter;
import com.example.dapindao.Interface.MysubscriptionInterface;
import com.example.dapindao.View.ArticleDetailsActivity;
import com.example.dapindao.View.MysubscriptionActivity;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.Utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MysubscriptionPresenter implements MysubscriptionInterface.Presenter {
    private MysubscriptionActivity activity;
    private MysubscriptionInterface.View view;
    private String token;
    public MysubscriptionPresenter(MysubscriptionInterface.View view,MysubscriptionActivity activity){
        this.activity = activity;
        this.view = view;
        token = Utils.getShared2(activity,"token");

    }

    @Override
    public void geSubProjectOnePage(int pageNum, int pageSize,int UserId) {
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).geSubProjectOnePage(token,pageNum,pageSize,UserId);
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
                            activity.adapter = new MysubscriptionAdapter(activity.getApplicationContext(),jsonElements);
                            activity.recyclerView.setAdapter(activity.adapter);
                            activity.adapter.setOnitemClickListener(new MysubscriptionAdapter.OnitemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {

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
                            if(totalPage>pageNum){
                                jsonElements.addAll(jsonElements);
                                view.onLoadMore();
                            }else {
                                view.onNothingData();
                            }

                        }else {
                            Toast.makeText(activity,jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
