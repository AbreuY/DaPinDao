package com.example.dapindao.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dapindao.Adapter.MycommentsAdapter;
import com.example.dapindao.Interface.MycommentsInterface;
import com.example.dapindao.Presenter.MycommentsPresenter;
import com.example.dapindao.R;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JzvdStd;

//回复我的
public class ReplyMeFragmnet extends Fragment implements MycommentsInterface.View {
    @BindView(R.id.refreshLayout)
    public SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    public RecyclerViewEmptySupport recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private MycommentsPresenter mycommentsPresenter;
    private MycommentsAdapter adapter;
    public View view;
    int pagenum = 1;
    int pagesize = 10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.replymefragmnet,container,false);
        ButterKnife.bind(this,view);
        initUI();
        mycommentsPresenter = new MycommentsPresenter(this,getActivity(),recyclerView,adapter);
        mycommentsPresenter.queryOwnCommentPage(pagenum,pagesize,"1");
        return view;
    }

    private void initUI(){
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mycommentsPresenter.queryOwnCommentPage(pagenum,pagesize,"1");
                JzvdStd.goOnPlayOnPause();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                mycommentsPresenter.queryOwnCommentPage(pagenum++,pagesize,"1");
                JzvdStd.goOnPlayOnPause();
            }
        });



    }

    @Override
    public void succeed() {

    }

    @Override
    public void failed() {
        refreshLayout.finishRefresh(true);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        refreshLayout.finishRefresh();//结束刷新
    }

    @Override
    public void onLoadMore() {
        adapter.notifyDataSetChanged();
        refreshLayout.finishLoadMore(true);
    }

    @Override
    public void onNothingData() {
        //没有更多数据了
        refreshLayout.finishLoadMoreWithNoMoreData();
    }
}
