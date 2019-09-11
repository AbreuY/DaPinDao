package com.example.dapindao.Presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.AlertAdapter;
import com.example.dapindao.Adapter.ArticleListsAdapter;
import com.example.dapindao.Adapter.HotListAdapter;
import com.example.dapindao.App.DapinDaoApp;
import com.example.dapindao.Interface.AlertsInterface;
import com.example.dapindao.Interface.ArticleListsInterface;
import com.example.dapindao.Interface.HotListInterface;
import com.example.dapindao.View.AlertsFragment;
import com.example.dapindao.View.Alertsdetails;
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

public class ArticleListsPresenter implements ArticleListsInterface.Presenter{
    private Context context;
    private ArticleListsInterface.View view;
    public ArticleListsAdapter adapter;
    private RecyclerViewEmptySupport recyclerViewEmptySupport;
    public ArticleListsPresenter(Context context,ArticleListsInterface.View view,RecyclerViewEmptySupport recyclerViewEmptySupport,ArticleListsAdapter adapter){
        this.context = context;
        this.view = view;
        this.recyclerViewEmptySupport = recyclerViewEmptySupport;
        this.adapter = adapter;
    }


    @Override
    public void queryArticlePageOwn(int pageNum, int pageSize) {
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).queryArticlePageOwn(DapinDaoApp.getToken(),pageNum,pageSize);
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
                            adapter = new ArticleListsAdapter(context,jsonElements);
                            recyclerViewEmptySupport.setAdapter(adapter);
                            int total = object.get("total").getAsInt();
                            int totalPage = object.get("totalPage").getAsInt();
                            if(total != 0){
                                view.onRefresh();
                            }else {
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
