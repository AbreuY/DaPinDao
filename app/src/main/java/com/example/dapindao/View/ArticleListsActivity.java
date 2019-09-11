package com.example.dapindao.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dapindao.Adapter.ArticleListsAdapter;
import com.example.dapindao.Interface.ArticleListsInterface;
import com.example.dapindao.Presenter.ArticleListsPresenter;
import com.example.dapindao.Presenter.ProjectPresenter;
import com.example.dapindao.R;
import com.example.dapindao.utils.AttachButton;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.example.dapindao.utils.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleListsActivity extends AppCompatActivity implements View.OnClickListener, ArticleListsInterface.View {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.refreshLayout)
    public SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    public RecyclerViewEmptySupport recyclerView;
    @BindView(R.id.send)
    AttachButton send;//发文
    private LinearLayoutManager mLinearLayoutManager;
    public ArticleListsAdapter adapter;
    private ArticleListsPresenter articleListsPresenter;
    private int pageNum = 1;
    private int pageSize = 10;
    private String isAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.articlelists);
        ButterKnife.bind(this);
        isAuth = Utils.getShared2(getApplicationContext(),"isAuth");
        back.setOnClickListener(this);
        send.setOnClickListener(this);
        initUI();
        initEvetn();
        articleListsPresenter = new ArticleListsPresenter(getApplicationContext(),this,recyclerView,adapter);
        articleListsPresenter.queryArticlePageOwn(pageNum,pageSize);
    }
    private void initUI(){
        mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                articleListsPresenter.queryArticlePageOwn(pageNum,pageSize);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                articleListsPresenter.queryArticlePageOwn(pageNum++,pageSize);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshLayout.autoRefresh();
    }

    private void initEvetn(){
        back.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == back){
            finish();
        }
        if(view == send){
            if(isAuth.equals("0")){
                final AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(ArticleListsActivity.this);
                alterDiaglog.setTitle("提示");//文字
                alterDiaglog.setMessage("身份未认证！");//提示消息
                alterDiaglog.setPositiveButton("前去认证", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(),CertificationActivity.class);
                        startActivity(intent);
                    }
                });
                alterDiaglog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                //显示
                alterDiaglog.show();
            }else if(isAuth.equals("2")){
                Utils.showToast("身份审核中");
            }else {
                Intent  intent = new Intent(getApplicationContext(),WritingCenterActivity.class);
                startActivity(intent);
            }

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
