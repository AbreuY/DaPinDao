package com.example.dapindao.View;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.dapindao.R;
import com.example.dapindao.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PasswordChangeActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.back)
    ImageView back;//返回
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passwordchange);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent(){
        back.setOnClickListener(this);
    }
    @Override
    protected void init() {

    }

    @Override
    public void onClick(View view) {
        if(view == back){
            finish();
        }
    }
}
