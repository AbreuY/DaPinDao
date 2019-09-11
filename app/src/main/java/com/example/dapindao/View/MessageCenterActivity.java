package com.example.dapindao.View;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dapindao.Adapter.MessageCenterAdapter;
import com.example.dapindao.Interface.MessageCenterInterface;
import com.example.dapindao.Presenter.MessageCenterPresenter;
import com.example.dapindao.Presenter.MyattentionPresenter;
import com.example.dapindao.R;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JzvdStd;

public class MessageCenterActivity extends BaseActivity implements View.OnClickListener , MessageCenterInterface.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.refreshLayout)
    public SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    public RecyclerViewEmptySupport recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private MessageCenterPresenter presenter;
    private MessageCenterAdapter adapter;
    private int PageNum = 1;
    private int PageSize = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messagecenter);
        ButterKnife.bind(this);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initUI();
        initEvetn();
        presenter = new MessageCenterPresenter(this,this,recyclerView,adapter);
        presenter.queryUserAppNoticePage(PageNum,PageSize);
    }

    private void initEvetn(){
        back.setOnClickListener(this);
    }
    private void initUI(){
        mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                presenter.queryUserAppNoticePage(PageNum,PageSize);
                JzvdStd.goOnPlayOnPause();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                presenter.queryUserAppNoticePage(PageNum++,PageSize);
                JzvdStd.goOnPlayOnPause();
            }
        });

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
