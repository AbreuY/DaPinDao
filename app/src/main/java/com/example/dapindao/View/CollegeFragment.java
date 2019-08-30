package com.example.dapindao.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.dapindao.Adapter.Adapter;
import com.example.dapindao.R;
import com.example.dapindao.utils.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollegeFragment extends Fragment {
    //学院
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    NoScrollViewPager view_pager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.collegepage,container,false);
        ButterKnife.bind(this,view);
        initUI();
        return view;
    }

    public void initUI(){
        AllFragmnet allFragmnet = new AllFragmnet();
        MyCoursesFragment mycourse = new MyCoursesFragment();
        mFragments.add(allFragmnet);
        mFragments.add(mycourse);
        list.add("全部");
        list.add("我的课程");
        tablayout.setupWithViewPager(view_pager);
        view_pager.setAdapter(new Adapter(getActivity().getSupportFragmentManager(),mFragments,list));

    }
}
