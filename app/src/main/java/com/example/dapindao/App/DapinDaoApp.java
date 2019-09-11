package com.example.dapindao.App;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.MycommentsAdapter;
import com.example.dapindao.Model.UserModel;
import com.example.dapindao.R;
import com.example.dapindao.View.LoginActivity;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.Utils;
import com.example.dapindao.wxapi.WxLogin;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tonyodev.fetch2.Fetch;
import com.tonyodev.fetch2.FetchConfiguration;
import com.tonyodev.fetch2.HttpUrlConnectionDownloader;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2okhttp.OkHttpDownloader;

import java.io.IOException;

import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DapinDaoApp extends Application {

    //以下属性应用于整个应用程序，合理利用资源，减少资源浪费
    private static Context mContext;//上下文
    private static Thread mMainThread;//主线程
    private static long mMainThreadId;//主线程id
    private static Looper mMainLooper;//循环队列
    private static Handler mHandler;//主线程Handler
    private static String token ;
    private static int UserId;

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context context) {
        DapinDaoApp.mContext = context;
    }
    public void onCreate() {
        super.onCreate();
        //对全局属性赋值
        mContext=getApplicationContext();
        mMainThread = Thread.currentThread();
        mMainThreadId = android.os.Process.myTid();
        mHandler = new Handler();
        token = Utils.getShared2(mContext,"token");
        UserId = Utils.getShared(mContext,"UserId");
        WxLogin.initWx(this);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        final FetchConfiguration fetchConfiguration = new FetchConfiguration.Builder(this)
                .enableRetryOnNetworkGain(true)
                .setDownloadConcurrentLimit(3)
                .setHttpDownloader(new HttpUrlConnectionDownloader(Downloader.FileDownloaderType.PARALLEL))
                // OR
                //.setHttpDownloader(getOkHttpDownloader())
                .build();
        Fetch.Impl.setDefaultInstanceConfiguration(fetchConfiguration);
    }
    private com.tonyodev.fetch2okhttp.OkHttpDownloader getOkHttpDownloader() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        return new OkHttpDownloader(okHttpClient,
                Downloader.FileDownloaderType.PARALLEL);
    }



    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.textcolor_t, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    /**
     * 重启当前应用
     */
    public static void restart() {
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(intent);
    }
    public static Thread getMainThread() {
        return mMainThread;
    }

    public static void setMainThread(Thread mMainThread) {
        DapinDaoApp.mMainThread = mMainThread;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static void setMainThreadId(long mMainThreadId) {
        DapinDaoApp.mMainThreadId = mMainThreadId;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    public static void setMainThreadLooper(Looper mMainLooper) {
        DapinDaoApp.mMainLooper = mMainLooper;
    }

    public static Handler getMainHandler() {
        return mHandler;
    }

    public static void setMainHandler(Handler mHandler) {
        DapinDaoApp.mHandler = mHandler;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        DapinDaoApp.token = token;
    }

    public static int getUserId() {
        return UserId;
    }

    public static void setUserId(int userId) {
        UserId = userId;
    }

    public static void LoadUserModel(String token){
        Call<UserModel> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).getUserBasicInfo(token,null);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.body()!=null){
                    if(response.body().getCode() == 0){
                        Utils.setShare(mContext,"deptId",response.body().getUser().getDeptId());
                        Utils.setShare2(mContext,"loginName",response.body().getUser().getLoginName());
                        Utils.setShare2(mContext,"userName",response.body().getUser().getUserName());
                        Utils.setShare2(mContext,"email",response.body().getUser().getEmail());
                        Utils.setShare2(mContext,"sex",response.body().getUser().getSex());
                        Utils.setShare2(mContext,"sex",response.body().getUser().getSex());
                        Utils.setShare2(mContext,"phonenumber",response.body().getUser().getPhonenumber());
                        Utils.setShare2(mContext,"avatarPath",response.body().getUser().getAvatarPath());
                        Utils.setShare2(mContext,"avatar",response.body().getUser().getAvatar());
                        Utils.setShare(mContext,"redEnvelope",response.body().getUser().getRedEnvelope());
                        Utils.setShare(mContext,"articleNum",response.body().getUser().getArticleNum());
                        Utils.setShare(mContext,"balance",response.body().getUser().getBalance());
                        Utils.setShare2(mContext,"fansNum", String.valueOf(response.body().getUser().getFansNum()));

                    }else {
                        Toast.makeText(mContext,"用户信息已过期，请重新登录！",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(mContext, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                        mContext.startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(mContext,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


        Call<ResponseBody> call1 = HttpHelper.getInstance().create(DaPinDaoAPI.class).getAuthStatusData(token);
        call1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    try {
                        String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            Utils.setShare2(mContext,"isAuth",jsonObject.get("isAuth").getAsString());
                        }else {
                            Toast.makeText(mContext,jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(mContext,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
