package com.example.dapindao.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.dapindao.R;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NickNameActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.userName)
    ClearEditText userName;//昵称
    @BindView(R.id.confirm)
    TextView confirm;//确定

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nickname);
        ButterKnife.bind(this);
        userName.setText(getIntent().getStringExtra("username"));
        initEvet();
    }

    private void initEvet(){
        confirm.setOnClickListener(this);
    }



    @Override
    protected void init() {

    }

    @Override
    public void onClick(View view) {
        if(view == confirm){

            Intent intent = new Intent();
            intent.putExtra("username", userName.getText().toString());
            // 返回intent
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
