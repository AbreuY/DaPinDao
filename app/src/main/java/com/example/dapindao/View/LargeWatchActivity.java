package com.example.dapindao.View;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.dapindao.Adapter.LargeWatchAdapter;
import com.example.dapindao.Adapter.VideoListAdapter;
import com.example.dapindao.Interface.AlertsInterface;
import com.example.dapindao.Presenter.LargeWatchPresenter;
import com.example.dapindao.R;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class LargeWatchActivity extends BaseActivity implements View.OnClickListener, AlertsInterface.View {

    @BindView(R.id.back)
     ImageView back;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.refreshLayout)
    public SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    public RecyclerViewEmptySupport recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    public LargeWatchAdapter adapter;
    private LargeWatchPresenter presenter;
    int pagenum = 1;
    int pagesize = 10;
    private SensorManager mSensorManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.largewatch);
        ButterKnife.bind(this);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initUI();
        initEvent();
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        presenter = new LargeWatchPresenter(LargeWatchActivity.this,this,adapter,recyclerView);
        presenter.recFront(7,pagenum,pagesize);
    }
    private void initUI(){
        mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                presenter.recFront(7,pagenum,pagesize);
                JzvdStd.goOnPlayOnPause();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                presenter.recFront(7,pagenum++,pagesize);
                JzvdStd.goOnPlayOnPause();
            }
        });



    }

    private void initEvent(){
        back.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.back:
            finish();
            break;
    }
    }

    @Override
    protected void onPause() {
        super.onPause();
        JzvdStd.goOnPlayOnPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        JzvdStd.goOnPlayOnResume();
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
