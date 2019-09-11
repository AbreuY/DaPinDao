package com.example.dapindao.View;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dapindao.Adapter.FilmCriticsAdapter;
import com.example.dapindao.Interface.AlertsInterface;
import com.example.dapindao.Presenter.FilmCriticsPresenter;
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


public class FilmCriticsActivity extends BaseActivity implements View.OnClickListener, AlertsInterface.View {

    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.refreshLayout)
    public SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerViewcourse)
    public RecyclerViewEmptySupport recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    public FilmCriticsAdapter adapter;
    private FilmCriticsPresenter presenter;
    @BindView(R.id.banner)
    public BannerViewPager banner;
    int pagenum = 1;
    int pagesize = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filmcriticsactivity);
        ButterKnife.bind(this);
        initUI();
        iv_back.setOnClickListener(this);
        toolbar_title.setText("影评");
        presenter = new FilmCriticsPresenter(this,banner,adapter,recyclerView,this);
        presenter.queryVedioesIsRecAll();
        presenter.recFront(6,pagenum,pagesize);
    }

    private void initUI(){
        gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                presenter.recFront(6,pagenum,pagesize);
                JzvdStd.goOnPlayOnPause();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                presenter.recFront(6,pagenum++,pagesize);
                JzvdStd.goOnPlayOnPause();
            }
        });
    }
    @Override
    protected void init() {

    }

    @Override
    public void onClick(View view) {
        if(view == iv_back){
            finish();
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
