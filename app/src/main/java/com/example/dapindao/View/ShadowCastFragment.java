package com.example.dapindao.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dapindao.Adapter.FilmCriticsAdapter;
import com.example.dapindao.Adapter.LargeWatchAdapter;
import com.example.dapindao.Adapter.ShadowCastAdapter;
import com.example.dapindao.Interface.AlertsInterface;
import com.example.dapindao.Presenter.FilmCriticsPresenter;
import com.example.dapindao.Presenter.LargeWatchPresenter;
import com.example.dapindao.Presenter.ShadowCastPresenter;
import com.example.dapindao.R;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.example.dapindao.utils.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JzvdStd;

//影投
public class ShadowCastFragment extends Fragment implements AlertsInterface.View {
    @BindView(R.id.refreshLayout)
    public SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    public RecyclerViewEmptySupport recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    public ShadowCastAdapter adapter;
    private ShadowCastPresenter presenter;
    int pagenum = 1;
    int pagesize = 10;
    public View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shadowcastfragment,container,false);
        ButterKnife.bind(this,view);
        initUI();
        presenter = new ShadowCastPresenter(this,this);
        presenter.recFront(9,pagenum,pagesize);

        return view;
    }

    private void initUI(){
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                presenter.recFront(9,pagenum,pagesize);
                JzvdStd.goOnPlayOnPause();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                presenter.recFront(9,pagenum++,pagesize);
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
