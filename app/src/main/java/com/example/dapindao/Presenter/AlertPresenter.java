package com.example.dapindao.Presenter;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.AlertAdapter;
import com.example.dapindao.Adapter.HotListAdapter;
import com.example.dapindao.Interface.AlertsInterface;
import com.example.dapindao.Interface.HotListInterface;
import com.example.dapindao.View.AlertsFragment;
import com.example.dapindao.View.Alertsdetails;
import com.example.dapindao.retrofit.HttpHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlertPresenter implements AlertsInterface.Presenter{
    private AlertsFragment fragment;
    private AlertsInterface.View view;
    public AlertPresenter(AlertsFragment fragment,AlertsInterface.View view){
        this.fragment = fragment;
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
                            fragment.adapter = new AlertAdapter(fragment.getContext(),jsonElements);
                            fragment.recyclerView.setAdapter(fragment.adapter);
                            fragment.adapter.setOnitemClickListener(new AlertAdapter.OnitemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    JsonObject object =jsonElements.get(position).getAsJsonObject();
                                    Intent intent = new Intent(fragment.getContext(), Alertsdetails.class);
                                    intent.putExtra("id",object.get("id").getAsString());
                                    fragment.startActivity(intent);
                                }
                            });
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
