package com.example.dapindao.Presenter;

import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.HotListAdapter;
import com.example.dapindao.Interface.HotListInterface;
import com.example.dapindao.Model.HotListModel;
import com.example.dapindao.View.HotListFragment;
import com.example.dapindao.retrofit.HttpHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotListPresenter implements HotListInterface.Presenter{
    private HotListFragment fragment;
    private HotListInterface.View view;
    private HotListModel model;
    public HotListPresenter(HotListInterface.View view,HotListFragment fragment){
        this.fragment = fragment;
        this.view = view;
    }

    @Override
    public void recFront(int type) {
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).recFront(type,0,0);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    try {
                        String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            if(!jsonObject.getAsJsonArray("list").isJsonNull()){
                                JsonArray jsonElements = jsonObject.getAsJsonArray("list");
                                fragment.adapter = new HotListAdapter(fragment.getContext(),jsonElements);
                                fragment.recyclerView.setAdapter(fragment.adapter);
                                fragment.adapter.notifyDataSetChanged();
                                view.failed();
                            }else {
                                Toast.makeText(fragment.getContext(),"16小时热榜无数据",Toast.LENGTH_LONG).show();
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
