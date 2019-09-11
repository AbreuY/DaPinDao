package com.example.dapindao.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.example.dapindao.Interface.IEditTextChangeListener;
import com.example.dapindao.Interface.LoginInterface;
import com.example.dapindao.MainActivity;
import com.example.dapindao.Presenter.LoginPresenter;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.Constants;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.WorksSizeCheckUtil;
import com.example.dapindao.wxapi.WxLogin;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import weiboAPI.WbAuthUtils;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginInterface.View {
    private TimeCount time;
    @BindView(R.id.exit_btn)
    ImageView exit_btn;//关闭按钮
    @BindView(R.id.moblie_phone)
   public EditText moblie_phone;//手机号码
    @BindView(R.id.registered_btn)
    TextView registered_btn;//注册
    @BindView(R.id.Verificationcode)
    EditText Verificationcode;//验证码
    @BindView(R.id.password_btn)
    TextView password_btn;//密码登录
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.weibobtn)
    ImageView weibobtn;//微博登录
    @BindView(R.id.weixin_login)
    ImageView weixin_login;//微信登录
    @BindView(R.id.Get_verification_code)
    TextView Get_verification_code;
    private int type = 1;
    Intent intent;
    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;
    private SsoHandler ssoHandler;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification_code_login);
        ButterKnife.bind(this);
        time = new TimeCount(90000, 1000);//构造CountDownTimer对象
        initEvent();
        loginPresenter = new LoginPresenter(this,this);
        //新浪微博初始化，对应的参数分别是app_key,回调地址，和权限
        AuthInfo mAuthInfo = new AuthInfo(this, Constants.WeiBoAPP_KEY,
                Constants.REDIRECT_URL, "");
        WbSdk.install(this, mAuthInfo);
        ssoHandler = new SsoHandler(this);
        WbAuthUtils utils = new WbAuthUtils();
        utils.setListener(new WbAuthUtils.onSuccessListener() {
            @Override
            public void onSuccess(final String result, final String icon, final String name) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //头像
                       // Glide.with(LoginActivity.this).load(icon).into(weiboPic);
                        //昵称
                       // weiboName.setText(name);
                        //json数据
                        Log.e("weiboJson", "run: "+result );
                    }
                });
            }

            @Override
            public void onFailure(String errorMessage) {
                //登录失败
                Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });


    }

    /**
     * SSO 授权回调
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 重要：发起 SSO 登陆的 Activity 必须重写 onActivityResults
        if (ssoHandler != null) {
            ssoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
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

    private void initEvent(){
        registered_btn.setOnClickListener(this);
        exit_btn.setOnClickListener(this);
        button.setOnClickListener(this);
        password_btn.setOnClickListener(this);
        Get_verification_code.setOnClickListener(this);
        exit_btn.setOnClickListener(this);
        weibobtn.setOnClickListener(this);
        weixin_login.setOnClickListener(this);

        //1.创建工具类对象 把要改变颜色的tv先传过去
        WorksSizeCheckUtil.textChangeListener textChangeListener = new WorksSizeCheckUtil.textChangeListener(button);

        //2.把所有要监听的edittext都添加进去
        textChangeListener.addAllEditText(moblie_phone,Verificationcode);

        //3.接口回调 在这里拿到boolean变量 根据isHasContent的值决定 tv 应该设置什么颜色
        WorksSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                if(isHasContent){
                    button.setEnabled(true);
                    button.setBackground(getResources().getDrawable(R.drawable.login_btn_backgroud_unfocus));
                }else{
                    button.setEnabled(false);
                    button.setBackground(getResources().getDrawable(R.drawable.login_btn_backgroud));
                }
            }
        });


    }

    @Override
    protected void init() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                //登录
                progressDialog = new ProgressDialog(LoginActivity.this,
                        R.style.AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("登陆中....");
                progressDialog.show();
                loginPresenter.login(moblie_phone.getText().toString(),Verificationcode.getText().toString());


                break;
            case R.id.password_btn:
                //密码登录
                if(type == 1){
                    moblie_phone.setText("");
                    Verificationcode.setText("");
                    button.setText("密码登录");
                    password_btn.setText("验证码登录");
                    Verificationcode.setHint("请输入密码");
                    Verificationcode.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    Get_verification_code.setVisibility(View.GONE);
                    type = 2;
                }else {
                    moblie_phone.setText("");
                    Verificationcode.setText("");
                    button.setText("验证码登录");
                    password_btn.setText("密码登录");
                    Verificationcode.setHint("请输入验证码");
                    Verificationcode.setInputType(InputType.TYPE_CLASS_PHONE);
                    Get_verification_code.setVisibility(View.VISIBLE);
                    type = 1;
                }
                break;
            case R.id.Get_verification_code:
                //获取验证码
                time.start();
                loginPresenter.sendMobileCode(moblie_phone.getText().toString());
                break;
            case R.id.registered_btn:
                //跳转到注册页面
               intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.exit_btn:
                finish();
                break;
            case R.id.weibobtn:
                //微博登录
                WbAuthUtils.startSinaWeiBo(ssoHandler);
                break;
            case R.id.weixin_login:
                //微信登录
                WxLogin.longWx();
                break;
        }
    }


    @Override
    public void succeed() {
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void failed() {
        progressDialog.dismiss();
    }
}
