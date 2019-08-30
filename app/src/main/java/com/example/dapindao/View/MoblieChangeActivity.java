package com.example.dapindao.View;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.App.DapinDaoApp;
import com.example.dapindao.Model.publicModel;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoblieChangeActivity extends BaseActivity implements View.OnClickListener {

    private Intent intent;
    @BindView(R.id.moblie_phone)
    TextView moblie_phone;
    private String moblie;
    @BindView(R.id.back)
    ImageView back;//返回
    @BindView(R.id.newMobile)
    EditText newMobile;//新手机好
    @BindView(R.id.code)
    EditText code;//验证码
    @BindView(R.id.Get_verification_code)
    TextView Get_verification_code;//获取验证码按钮
    @BindView(R.id.confirm_btn)
    Button confirm_btn;//确定
    private String token;
    private TimeCount time;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobliechange);
        ButterKnife.bind(this);
        token = Utils.getShared2(getApplicationContext(),"token");
        time = new TimeCount(90000, 1000);//构造CountDownTimer对象
        initdata();
        initEvent();
    }

    private void initdata(){
        intent = getIntent();
        moblie = intent.getStringExtra("moblie");
        moblie_phone.setText("当前绑定 +86 "+moblie.substring(0,3)+"****"+moblie.substring(7,moblie.length()));
    }
    private void initEvent(){
        back.setOnClickListener(this);
        Get_verification_code.setOnClickListener(this);
        confirm_btn.setOnClickListener(this);
    }


    @Override
    protected void init() {

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {//计时完毕时触发
            Get_verification_code.setText("获取验证码");
            Get_verification_code.setClickable(true);

        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            Get_verification_code.setClickable(false);
            Get_verification_code.setText("倒计时" + millisUntilFinished / 1000);

        }
    }

    @Override
    public void onClick(View view) {
        if(view == back){
            finish();
        }
        if(view == Get_verification_code){
            //获取验证码

            if (!Utils.isMobileNO(newMobile.getText().toString())) {
                Toast.makeText(this, "手机号码格式不正确！", Toast.LENGTH_LONG).show();
            } else {
                time.start();
                Call<publicModel> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).sendMobileCode(moblie_phone.getText().toString(),"0");
                call.enqueue(new Callback<publicModel>() {
                    @Override
                    public void onResponse(Call<publicModel> call, Response<publicModel> response) {
                        if (response.body() != null) {
                            if (response.body().getCode() == 0) {
                                Toast.makeText(getApplicationContext(), "验证码发送成功！", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<publicModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        }

        if(view == confirm_btn){
            //确定提交
            if(TextUtils.isEmpty(code.getText().toString())){
                Toast.makeText(getApplicationContext(),"验证码不能为空",Toast.LENGTH_LONG).show();
            }else {
                Call<publicModel> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).bindMobile(token,moblie,newMobile.getText().toString(),code.getText().toString());
                call.enqueue(new Callback<publicModel>() {
                    @Override
                    public void onResponse(Call<publicModel> call, Response<publicModel> response) {
                        if(response.body()!=null){
                            if(response.body().getCode() == 0){
                                Toast.makeText(getApplicationContext(),response.body().getMsg(),Toast.LENGTH_LONG).show();
                                DapinDaoApp.LoadUserModel(token);
                                finish();
                            }else {
                                Toast.makeText(getApplicationContext(),response.body().getMsg(),Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<publicModel> call, Throwable t) {

                    }
                });
            }
        }
    }
}
