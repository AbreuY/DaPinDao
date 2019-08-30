package com.example.dapindao.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.dapindao.Adapter.Adapters;
import com.example.dapindao.R;
import com.example.dapindao.utils.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCoursesFragment extends Fragment {
    //我的课程
    public View view;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    NoScrollViewPager view_pager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mycourse,container,false);
        ButterKnife.bind(this,view);
        initUI();
        return view;
    }

    public void initUI(){
        CollectionFragment collectionFragment = new CollectionFragment();
        PurchasedFragment purchasedFragment = new PurchasedFragment();
        mFragments.add(collectionFragment);
        mFragments.add(purchasedFragment);
        list.add("收藏");
        list.add("已购买");
        tablayout.setupWithViewPager(view_pager);
        view_pager.setAdapter(new Adapters(getChildFragmentManager(),mFragments,list));
    }
}
