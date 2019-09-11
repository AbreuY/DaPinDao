package com.example.dapindao.View;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.dapindao.Adapter.Adapter;
import com.example.dapindao.R;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MycommentsActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.back)
    ImageView back;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycomments);
        ButterKnife.bind(this);
        back.setOnClickListener(this);
        initUI();
    }
    public void initUI(){
        AcommentFragment acommentFragment = new AcommentFragment();
        ReplyMeFragmnet replyMeFragmnet = new ReplyMeFragmnet();

        mFragments.add(replyMeFragmnet);
        mFragments.add(acommentFragment);

        list.add("回复我的");
        list.add("我发出的");

        tablayout.setupWithViewPager(view_pager);
        view_pager.setAdapter(new Adapter(getSupportFragmentManager(),mFragments,list));

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
}
