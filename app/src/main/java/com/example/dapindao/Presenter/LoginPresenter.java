package com.example.dapindao.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Interface.LoginInterface;
import com.example.dapindao.MainActivity;
import com.example.dapindao.Model.Registered;
import com.example.dapindao.Model.publicModel;
import com.example.dapindao.View.LoginActivity;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginInterface.Presenter {
    private LoginActivity context;
    private LoginInterface.View view;
    private Registered registered;
    public LoginPresenter(LoginActivity context,LoginInterface.View view){
        this.context = context;
        this.view = view;

    }

    @Override
    public void login(String mobile, String code) {
        //登录
        String deviceId = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
        String device_model = Build.MODEL;
        Call<Registered> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).loginByCode(mobile,code,"2",device_model,deviceId,"3");
        call.enqueue(new Callback<Registered>() {
            @Override
            public void onResponse(Call<Registered> call, Response<Registered> response) {
                if(response.body()!= null){
                    if(response.body().getCode() == 0){
                        registered = new Registered();
                        registered.setDeviceType(response.body().getDeviceType());
                        registered.setToken(response.body().getToken());
                        registered.setUserId(response.body().getUserId());
                        Utils.setShare2(context,"token",response.body().getToken()+"::2");
                        Utils.setShare(context,"UserId",response.body().getUserId());

                        Toast.makeText(context,"登录成功",Toast.LENGTH_LONG).show();
                        view.succeed();
                    }else {
                        Toast.makeText(context,response.body().getMsg(),Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Registered> call, Throwable t) {

            }
        });
    }

    @Override
    public void sendMobileCode(String code) {
        //获取短信验证码
        //获取验证码
        if (!Utils.isMobileNO(context.moblie_phone.getText().toString())) {
            Toast.makeText(context, "手机号码格式不正确！", Toast.LENGTH_LONG).show();
        } else {
            Call<publicModel> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).sendMobileCode(context.moblie_phone.getText().toString(),"0");
            call.enqueue(new Callback<publicModel>() {
                @Override
                public void onResponse(Call<publicModel> call, Response<publicModel> response) {
                    if (response.body() != null) {
                        if (response.body().getCode() == 0) {
                            Toast.makeText(context, "验证码发送成功！", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(context, response.body().getMsg(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
                @Override
                public void onFailure(Call<publicModel> call, Throwable t) {
                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
