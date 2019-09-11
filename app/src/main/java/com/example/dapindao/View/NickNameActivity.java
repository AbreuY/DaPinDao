package com.example.dapindao.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.App.DapinDaoApp;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.ClearEditText;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NickNameActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.userName)
    ClearEditText userName;//昵称
    @BindView(R.id.confirm)
    TextView confirm;//确定
    @BindView(R.id.back)
    ImageView back;//返回

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
        back.setOnClickListener(this);
    }



    @Override
    protected void init() {

    }

    @Override
    public void onClick(View view) {
        if(view == confirm){
            Call<ResponseBody> call2 = HttpHelper.getInstance().create(DaPinDaoAPI.class).updateBasicInfo(DapinDaoApp.getToken(),userName.getText().toString(),"","");
            call2.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.body()!=null){
                        String jsonStr = null;//把原始数据转为字符串
                        try {
                            jsonStr = new String(response.body().bytes());
                            JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                            if(jsonObject.get("code").getAsInt() == 0){
                                DapinDaoApp.LoadUserModel(DapinDaoApp.getToken());
                                Toast.makeText(getApplicationContext(),jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
                                Intent intent = new Intent();
                                intent.putExtra("username", userName.getText().toString());
                                // 返回intent
                                setResult(RESULT_OK, intent);
                                finish();
                            }else {
                                Toast.makeText(getApplicationContext(),jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });

        }
        if(view == back){
           finish();
        }
    }
}
