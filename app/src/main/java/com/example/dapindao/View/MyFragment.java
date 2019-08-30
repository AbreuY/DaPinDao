package com.example.dapindao.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.dapindao.R;
import com.example.dapindao.utils.Utils;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFragment extends Fragment implements View.OnClickListener {
    //我的
    private View view;
    @BindView(R.id.login_btn)
    Button login_btn;//登录按钮
    @BindView(R.id.regist_btn)
    Button regist_btn;
    Intent intent;
    @BindView(R.id.messagecenter)
    LinearLayout messagecenter;//消息中心
    @BindView(R.id.Myattention)
    LinearLayout Myattention;//我的关注
    @BindView(R.id.Mysubscription)
    LinearLayout Mysubscription;//我的订阅
    @BindView(R.id.Mycomments)
    LinearLayout Mycomments;//我的评论
    @BindView(R.id.Mycollection)
    LinearLayout Mycollection;//我的收藏
    @BindView(R.id.Browsinghistory)
    LinearLayout Browsinghistory;//浏览记录
    @BindView(R.id.Goodreading)
    LinearLayout Goodreading;//公益阅读
    @BindView(R.id.Myresearchreport)
    LinearLayout Myresearchreport;//我的研究报告
    @BindView(R.id.mycourses)
    LinearLayout mycourses;//我的课程
    @BindView(R.id.feedback)
    LinearLayout feedback;//意见反馈
    @BindView(R.id.Seekingtoreport)
    LinearLayout Seekingtoreport;//寻求报道
    String token ;
    @BindView(R.id.constraintLayout2)
    ConstraintLayout constraintLayout2;
    @BindView(R.id.constraintLayout1)
    ConstraintLayout constraintLayout1;
    @BindView(R.id.setting_btn)
    ImageView setting_btn;//设置
    @BindView(R.id.Personalcenter)
    TextView Personalcenter;//个人中心
    @BindView(R.id.roundedImageView)
    RoundedImageView roundedImageView;
    private String avatarPath;//头像地址
    @BindView(R.id.userName)
    TextView userName;//用户昵称

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mypage,container,false);
        ButterKnife.bind(this,view);
        token= Utils.getShared2(getActivity(),"token");
        initUI();
        initEvent();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        avatarPath = Utils.getShared2(getActivity(),"avatarPath");
        if(avatarPath.equals("")){
            roundedImageView.setImageDrawable(null);
        }else {
            Glide.with(getActivity())
                    .load(avatarPath)
                    .into(roundedImageView);
        }
        if(Utils.getShared2(getActivity(),"userName").equals("")){
            userName.setText("设置个人昵称");
        }else {
            userName.setText(Utils.getShared2(getActivity(),"userName"));
        }

    }

    private void initUI(){
        if(!token.equals("")){
            constraintLayout1.setVisibility(View.GONE);
            constraintLayout2.setVisibility(View.VISIBLE);
        }else {
            constraintLayout1.setVisibility(View.VISIBLE);
            constraintLayout2.setVisibility(View.GONE);
        }
    }
    private void initEvent(){
        login_btn.setOnClickListener(this);
        regist_btn.setOnClickListener(this);
        messagecenter.setOnClickListener(this);
        Myattention.setOnClickListener(this);
        Mysubscription.setOnClickListener(this);
        Mycomments.setOnClickListener(this);
        Mycollection.setOnClickListener(this);
        Browsinghistory.setOnClickListener(this);
        Goodreading.setOnClickListener(this);
        Myresearchreport.setOnClickListener(this);
        mycourses.setOnClickListener(this);
        feedback.setOnClickListener(this);
        Seekingtoreport.setOnClickListener(this);
        setting_btn.setOnClickListener(this);
        Personalcenter.setOnClickListener(this);
        roundedImageView.setOnClickListener(this);
        userName.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn:
                //登录
                intent = new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.regist_btn:
                //注册
                intent = new Intent(getContext(),RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.messagecenter :
                intent = new Intent(getContext(),MessageCenterActivity.class);
                startActivity(intent);
                //消息中心
                break;
            case R.id.Myattention :
                intent = new Intent(getContext(),MyattentionActivity.class);
                startActivity(intent);
                //我的关注
                break;
            case R.id.Mysubscription :
                intent = new Intent(getContext(),MysubscriptionActivity.class);
                startActivity(intent);
                //我的订阅
                break;
            case R.id.Mycomments :
                //我的评论
                break;
            case R.id.Mycollection :
                intent = new Intent(getContext(),MycollectionActivity.class);
                startActivity(intent);
                //我的收藏
                break;
            case R.id.Browsinghistory :
                //浏览记录
                break;
            case R.id.Goodreading :
                //公益阅读
                break;
            case R.id.Myresearchreport :
                //我的研究报告
                break;
            case R.id.mycourses :
                //我的课程
                break;
            case R.id.feedback :
                //意见反馈
                break;
            case R.id.Seekingtoreport :
                //寻求报道
                break;
            case R.id.setting_btn:
                //设置界面
                intent = new Intent(getContext(),SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.Personalcenter:
                //个人中心
                intent = new Intent(getActivity(),PersonalCenterActivity.class);
                startActivity(intent);

                break;
            case R.id.roundedImageView:
                //个人中心
                intent = new Intent(getActivity(),PersonalCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.userName:
                //个人中心
                intent = new Intent(getActivity(),PersonalCenterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
