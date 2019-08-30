package com.example.dapindao.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.dapindao.R;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountSettingActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.moblie_phone)
    TextView moblie_phone;
    private String phonenumber;
    @BindView(R.id.Password_change)
    RelativeLayout Password_change;//修改密码
    @BindView(R.id.moblie_change)
    RelativeLayout moblie_change;//修改手机号
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountsetting);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent(){
        back.setOnClickListener(this);
        Password_change.setOnClickListener(this);
        moblie_change.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        phonenumber = Utils.getShared2(getApplicationContext(),"phonenumber");
        moblie_phone.setText(phonenumber.substring(0,3)+"****"+phonenumber.substring(7,phonenumber.length()));
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.Password_change:
                //修改密码
                intent = new Intent(getApplicationContext(),PasswordChangeActivity.class);
                startActivity(intent);

                break;
            case R.id.moblie_change:
                //修改手机号
                intent = new Intent(getApplicationContext(),MoblieChangeActivity.class);
                intent.putExtra("moblie",phonenumber);
                startActivity(intent);
                break;
        }
    }
}
