package com.example.dapindao.View;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.dapindao.R;
import com.example.dapindao.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAgreementActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.Useragreement_web)
    WebView Useragreement_web;//用户协议
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.iv_back)
    ImageView iv_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useragreement);
        ButterKnife.bind(this);
        toolbar_title.setText("用户协议");
        iv_back.setOnClickListener(this);
        // 格式规定为:file:////android_asset/文件名.html
        Useragreement_web.loadUrl("file:////android_asset/userAgreement.html");
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View view) {
        if(view == iv_back){
            finish();
        }
    }
}
