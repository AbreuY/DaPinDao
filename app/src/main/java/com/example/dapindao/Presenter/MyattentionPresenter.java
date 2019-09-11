package com.example.dapindao.Presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.MyattentionAdapter;
import com.example.dapindao.App.DapinDaoApp;
import com.example.dapindao.Interface.MyattentionInterface;
import com.example.dapindao.View.MyattentionActivity;
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

public class MyattentionPresenter implements MyattentionInterface.Presenter{
    private Context context;
    private MyattentionInterface.View view;
    private MyattentionAdapter adapter;
    private RecyclerViewEmptySupport recyclerViewEmptySupport;
    public MyattentionPresenter(Context context, MyattentionInterface.View view, RecyclerViewEmptySupport recyclerViewEmptySupport){
        this.view = view;
        this.context = context;
        this.recyclerViewEmptySupport = recyclerViewEmptySupport;
    }

    @Override
    public void queryUserFansList(String type, int pagenum, int pagesize) {
        Call<ResponseBody> call2 = HttpHelper.getInstance().create(DaPinDaoAPI.class).queryUserFansList(DapinDaoApp.getToken(),"1",pagenum,pagesize);
        call2.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    String jsonStr = null;//把原始数据转为字符串
                    try {
                        jsonStr = new String(response.body().bytes());
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            JsonObject object = jsonObject.get("result").getAsJsonObject();
                            JsonArray jsonElements = object.getAsJsonArray("rows");
                            adapter = new MyattentionAdapter(context,jsonElements);
                            recyclerViewEmptySupport.setAdapter(adapter);
                            int total = object.get("total").getAsInt();
                            int totalPage = object.get("totalPage").getAsInt();
                            if(total != 0){
                                view.onRefresh();
                            }else {
                                // publicCue.loadAdapter(beanList);
                                view.failed();
                            }
                            if(totalPage>pagenum){
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
