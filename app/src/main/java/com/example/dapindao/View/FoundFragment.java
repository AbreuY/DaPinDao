package com.example.dapindao.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dapindao.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private List<String> listurl = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.foundpage,container,false);
        ButterKnife.bind(this,view);
        initUI();
        initEvent();
        String url1 = "http://chuantu.xyz/t6/702/1565596493x2890191699.jpg";
        String url2 = "http://chuantu.xyz/t6/702/1565596561x1033347913.jpg";
        String url3 = "http://chuantu.xyz/t6/702/1565596594x1031866013.jpg";
        listurl.add(url1);
        listurl.add(url2);
        listurl.add(url3);
        mViewPager.initBanner(listurl, false)//图片地址，关闭3D画廊效果
                .addPageMargin(15, 60)//参数1page之间的间距,参数2中间item距离边界的间距
                .addPoint(5)//添加指示器,5dp
                .addPointBottom(7)
                .addStartTimer(5)//自动轮播5秒间隔
                .addRoundCorners(12)//圆角
                .finishConfig()//这句必须加
                .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                    @Override
                    public void onBannerClick(int position) {
                        //点击item
                    }
                });
        return view;
    }

    private void initUI(){

    }
    private void  initEvent(){
        lin_subscribe.setOnClickListener(this);
        lin_yaokan.setOnClickListener(this);
        project_lin.setOnClickListener(this);
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
        }
    }
}
