package com.example.dapindao.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Presenter.FoundPresenter;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.example.dapindao.utils.Utils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoundFragment extends Fragment implements View.OnClickListener {
    //发现
    private View view;
    @BindView(R.id.banner)
    BannerViewPager mViewPager;
    @BindView(R.id.lin_subscribe)
    LinearLayout lin_subscribe;//订阅
    @BindView(R.id.lin_yaokan)
    LinearLayout lin_yaokan;//幺看
    @BindView(R.id.project_lin)
    LinearLayout project_lin;
    @BindView(R.id.lin_FilmCritics)
    LinearLayout lin_FilmCritics;//影评
    @BindView(R.id.Writingcenter_lin)
    LinearLayout Writingcenter_lin;//创作中心
    private FoundPresenter presenter;
    @BindView(R.id.group)
    public LinearLayout group;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.foundpage,container,false);
        ButterKnife.bind(this,view);
        initUI();
        initEvent();
        presenter = new FoundPresenter(getActivity(),mViewPager,group);
        presenter.mainPage(3);
        return view;
    }


    private void initUI(){

    }
    private void  initEvent(){
        lin_subscribe.setOnClickListener(this);
        lin_yaokan.setOnClickListener(this);
        project_lin.setOnClickListener(this);
        lin_FilmCritics.setOnClickListener(this);
        Writingcenter_lin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.lin_subscribe:
                //订阅
                intent = new Intent(getContext(),MysubscriptionActivity.class);
                startActivity(intent);
                break;
            case R.id.lin_yaokan:

                intent = new Intent(getContext(),LargeWatchActivity.class);
                startActivity(intent);
                break;
            case R.id.project_lin:
                //专题
                intent = new Intent(getContext(),ProjectActivity.class);
                startActivity(intent);
                break;
            case R.id.lin_FilmCritics:
                //影评
                intent = new Intent(getContext(),FilmCriticsActivity.class);
                startActivity(intent);
                break;
            case R.id.Writingcenter_lin:
                //创作中心
                intent = new Intent(getContext(),ArticleListsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
