package com.example.dapindao.Presenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.ProjectAdapter;
import com.example.dapindao.Interface.ProjectInterface;
import com.example.dapindao.Model.ProjectModel;
import com.example.dapindao.View.LevelProjectActivity;
import com.example.dapindao.View.ProjectActivity;
import com.example.dapindao.retrofit.HttpHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectPresenter implements ProjectInterface.Presenter {
    private ProjectActivity activity;
    private ProjectInterface.View view;
    private ProjectModel projectModel;
    private List<ProjectModel.ResultBean.RowsBean> list = new ArrayList<>();
    public ProjectPresenter(ProjectActivity activity,ProjectInterface.View view){
        this.activity = activity;
        this.view = view;
    }

    @Override
    public void getType1Page(int pageNum, int pageSize, String search,int userId) {
        Call<ProjectModel> call= HttpHelper.getInstance().create(DaPinDaoAPI.class).getType1Page(pageNum,pageSize,search,userId);
        call.enqueue(new Callback<ProjectModel>() {
            @Override
            public void onResponse(Call<ProjectModel> call, Response<ProjectModel> response) {
                if(response.body() != null){
                    if(response.body().getCode() == 0){
                        projectModel = new ProjectModel();
                        projectModel.setResult(response.body().getResult());
                        list = projectModel.getResult().getRows();
                        int  total = projectModel.getResult().getTotal();
                        int totalPage = projectModel.getResult().getTotalPage();
                        activity.adapter = new ProjectAdapter(activity,list);
                        activity.recyclerView.setAdapter(activity.adapter);
                        activity.adapter.setOnitemClickListener(new ProjectAdapter.OnitemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Log.e("TAG", "onItemClick: "+list.get(position).getId() );
                                Intent intent = new Intent(activity, LevelProjectActivity.class);
                                String id = String.valueOf(list.get(position).getId());
                                intent.putExtra("id",id);
                                activity.startActivity(intent);
                            }
                        });
                        if(total != 0){
                            view.onRefresh();
                        }else {
                            // publicCue.loadAdapter(beanList);
                            view.failed();
                        }
                        if(totalPage>pageNum){
                            list.addAll(projectModel.getResult().getRows());
                            view.onLoadMore();
                        }else {
                            view.onNothingData();
                        }

                    }else {
                        Toast.makeText(activity,response.body().getMsg(),Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<ProjectModel> call, Throwable t) {
                Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
