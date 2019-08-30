package com.example.dapindao.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.dapindao.Adapter.Adapter;
import com.example.dapindao.Adapter.Adapters;
import com.example.dapindao.R;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoListActivity extends BaseActivity {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    NoScrollViewPager view_pager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videolist);
        ButterKnife.bind(this);
        initUI();
    }

    @Override
    protected void init() {

    }

    public void initUI(){
         HavedownloadedFragment havedownloadedFragment = new HavedownloadedFragment();
        DownloadingFragment downloadingFragment = new DownloadingFragment();
        mFragments.add(havedownloadedFragment);
        mFragments.add(downloadingFragment);
        list.add("已下载");
        list.add("下载中");
        tablayout.setupWithViewPager(view_pager);
        view_pager.setAdapter(new Adapters(getSupportFragmentManager(),mFragments,list));
    }
}
