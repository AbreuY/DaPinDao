package com.example.dapindao.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dapindao.Adapter.CourseAdapters;
import com.example.dapindao.Adapter.TheArticleAdapters;
import com.example.dapindao.Interface.RecommendedInterface;
import com.example.dapindao.Presenter.RecommendedPresenter;
import com.example.dapindao.R;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendedFragment extends Fragment implements RecommendedInterface.View {

    public View view;
    @BindView(R.id.banner)
    public BannerViewPager banner;//轮播图
    private RecommendedPresenter presenter;
    @BindView(R.id.refreshLayout)
    public SmartRefreshLayout  refreshLayout;
    @BindView(R.id.group)
    public LinearLayout group;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recommendedfragment,container,false);
        ButterKnife.bind(this,view);
        initUI();
        presenter = new RecommendedPresenter(this,this);
        presenter.recFront(3);

        return view;

    }
    private void initUI(){
        refreshLayout.setEnableRefresh(true);
        refreshLayout.setEnableLoadMore(false);
    }

    @Override
    public void succeed() {

    }

    @Override
    public void failed() {

    }
}
