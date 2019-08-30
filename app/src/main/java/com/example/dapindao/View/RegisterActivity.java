package com.example.dapindao.View;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Interface.IEditTextChangeListener;
import com.example.dapindao.MainActivity;
import com.example.dapindao.Model.Registered;
import com.example.dapindao.Model.publicModel;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.ApiResults;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.Utils;
import com.example.dapindao.utils.WorksSizeCheckUtil;
import com.socks.library.KLog;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private TimeCount time;
    @BindView(R.id.login_btn)
    TextView login_btn;//登录
    @BindView(R.id.moblie_phone)
    EditText moblie_phone;//手机号码
    @BindView(R.id.Verificationcode)
    EditText Verificationcode;//验证码
/*    @BindView(R.id.password)
    EditText password;//密码*/
    @BindView(R.id.button)
    Button button;//注册
    @BindView(R.id.exit_btn)
    ImageView exit_btn;//关闭
/*    @BindView(R.id.pwd_view)
    ImageView pwd_view;//显示与隐藏密码*/
    @BindView(R.id.Get_verification_code)
    TextView Get_verification_code;//获取验证码
    private int type = 1;
    Registered registered;
    Intent intent;
    JSONObject requestData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerxml);
        ButterKnife.bind(this);
        time = new TimeCount(90000, 1000);//构造CountDownTimer对象
        initEvent();
    }

    private void initEvent() {
        login_btn.setOnClickListener(this);
        button.setOnClickListener(this);
       // pwd_view.setOnClickListener(this);
        exit_btn.setOnClickListener(this);
        Get_verification_code.setOnClickListener(this);
        //1.创建工具类对象 把要改变颜色的tv先传过去
        WorksSizeCheckUtil.textChangeListener textChangeListener = new WorksSizeCheckUtil.textChangeListener(button);

        //2.把所有要监听的edittext都添加进去
        textChangeListener.addAllEditText(moblie_phone, Verificationcode);

        //3.接口回调 在这里拿到boolean变量 根据isHasContent的值决定 tv 应该设置什么颜色
        WorksSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                if (isHasContent) {
                    button.setEnabled(true);
                    button.setBackground(getResources().getDrawable(R.drawable.login_btn_backgroud_unfocus));
                } else {
                    button.setEnabled(false);
                    button.setBackground(getResources().getDrawable(R.drawable.login_btn_backgroud));
                }
            }
        });
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
    protected void init() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
         /*   case R.id.pwd_view:
                //显示或隐藏密码
                if (type == 1) {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    pwd_view.setImageDrawable(getResources().getDrawable(R.mipmap.invisible));
                    type = 2;
                } else {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    pwd_view.setImageDrawable(getResources().getDrawable(R.mipmap.visible));
                    type = 1;
                }
                break;*/
            case R.id.login_btn:
                //跳转到登录页面
                break;
            case R.id.Get_verification_code:
                //获取验证码
                time.start();
                if (!Utils.isMobileNO(moblie_phone.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "手机号码格式不正确！", Toast.LENGTH_LONG).show();
                } else {
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
                break;
            case R.id.button:
                //注册按钮

                String deviceId = Settings.System.getString(getApplication().getContentResolver(), Settings.System.ANDROID_ID);
                Log.e("TAG", "onClick: "+deviceId );
                    String device_model = Build.MODEL;
                    Call<Registered> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).register(moblie_phone.getText().toString(),Verificationcode.getText().toString(),"2",device_model,"3",deviceId,"");
                KLog.e("moblie_phone",moblie_phone.getText().toString());
                KLog.e("Verificationcode",Verificationcode.getText().toString());
                KLog.e("deviceType","2");
                KLog.e("deviceName",device_model);
                KLog.e("platform","3");
                KLog.e("deviceId",deviceId);
                KLog.e("password","");
                    call.enqueue(new Callback<Registered>() {
                    @Override
                    public void onResponse(Call<Registered> call, Response<Registered> response) {
                        if(response.body()!= null){
                            if(response.body().getCode() == 0){
                                    registered = new Registered();
                                    registered.setDeviceType(response.body().getDeviceType());
                                    registered.setToken(response.body().getToken());
                                    registered.setUserId(response.body().getUserId());
                                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_LONG).show();
                                    intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();

                            }else {
                                Toast.makeText(getApplicationContext(),response.body().getMsg(),Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Registered> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            break;
        case R.id.exit_btn:
            finish();
            break;
    }
    }
}
