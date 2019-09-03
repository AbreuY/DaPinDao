package com.example.dapindao.Presenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.ProjectAdapter;
import com.example.dapindao.Interface.ProjectInterface;
import com.example.dapindao.Model.ProjectModel;
import com.example.dapindao.View.LevelProjectActivity;
import com.example.dapindao.View.ProjectActivity;
import com.example.dapindao.View.ProjectFragment;
import com.example.dapindao.retrofit.HttpHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectFragmentPresent implements ProjectInterface.Presenter {
    private ProjectFragment activity;
    private ProjectInterface.View view;
    private ProjectModel projectModel;
    private List<ProjectModel.ResultBean.RowsBean> list = new ArrayList<>();

    public ProjectFragmentPresent(ProjectFragment activity,ProjectInterface.View view){
        this.activity = activity;
        this.view = view;
    }

    @Override
    public void getType1Page(int pageNum, int pageSize, String search,int UserId) {
        Call<ProjectModel> call= HttpHelper.getInstance().create(DaPinDaoAPI.class).getType1Page(pageNum,pageSize,search,UserId);
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
                        activity.adapter = new ProjectAdapter(activity.getActivity(),list);
                        activity.recyclerView.setAdapter(activity.adapter);
                        activity.adapter.setOnitemClickListener(new ProjectAdapter.OnitemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(activity.getActivity(), LevelProjectActivity.class);
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
                        Toast.makeText(activity.getActivity(),response.body().getMsg(),Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<ProjectModel> call, Throwable t) {
                Toast.makeText(activity.getActivity(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
