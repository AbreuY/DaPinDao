package com.example.dapindao.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dapindao.Adapter.ResearchReportAdapter;
import com.example.dapindao.R;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResearchReportFragment extends Fragment {
    //研报
    private View view;
    @BindView(R.id.refreshLayout)
    public SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    public RecyclerViewEmptySupport recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private ResearchReportAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.researchreportfragment,container,false);
        ButterKnife.bind(this,view);
        initUI();
        adapter = new ResearchReportAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
    private void initUI(){
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        refreshLayout.setEnableRefresh(true);
        refreshLayout.setEnableLoadMore(false);

    }
}
