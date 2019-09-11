package com.example.dapindao.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.App.DapinDaoApp;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.MyBottomSheetDialog;
import com.example.dapindao.utils.Utils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hyb.library.PreventKeyboardBlockUtil;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.InvokeParam;
import org.devio.takephoto.model.TContextWrap;
import org.devio.takephoto.model.TResult;
import org.devio.takephoto.permission.InvokeListener;
import org.devio.takephoto.permission.PermissionManager;
import org.devio.takephoto.permission.TakePhotoInvocationHandler;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CertificationActivity extends AppCompatActivity implements View.OnClickListener, TakePhoto.TakeResultListener, InvokeListener {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.iv_back)
    ImageView back;//返回
    @BindView(R.id.cardPoFile)
    ImageView cardPoFile;//身份证正面
    @BindView(R.id.cardNeFile)
    ImageView cardNeFile;//身份证反面
    @BindView(R.id.cardAllFile)
    ImageView cardAllFile;//手持身份证
    @BindView(R.id.actName)
    EditText actName;//真实姓名
    @BindView(R.id.actCard)
    EditText actCard;//身份证号
    private TakePhoto takePhoto;
    public InvokeParam invokeParam;
    @BindView(R.id.button)
    Button button;//提交
    private String cardPoFileiconPath;
    private String cardNeFileiconPath;
    private String cardAllFileiconPath;
    private int type;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.certification);
        ButterKnife.bind(this);
        toolbar_title.setText("身份认证");
        initEvent();

    }
    private void initEvent(){
        back.setOnClickListener(this);
        cardPoFile.setOnClickListener(this);
        cardNeFile.setOnClickListener(this);
        cardAllFile.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    /** * 获取TakePhoto实例 * @return */
    public TakePhoto getTakePhoto(){
        if (takePhoto==null){
            takePhoto= (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this,this));
        }
        //设置压缩规则，最大500kb
        takePhoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(500 * 1024).create(), true);
        return takePhoto;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {
                if (requestCode == 1){
                    //处理调用系统图库
                }
            }
        }
    }

    @Override
    public void takeSuccess(TResult result) {
        if(type == 1){
            cardPoFileiconPath = result.getImage().getOriginalPath();
            Glide.with(this).load(cardPoFileiconPath).into(cardPoFile);
        }
        if(type == 2){
            cardNeFileiconPath = result.getImage().getOriginalPath();
            Glide.with(this).load(cardNeFileiconPath).into(cardNeFile);
        }
        if(type == 3){
            cardAllFileiconPath = result.getImage().getOriginalPath();
            Glide.with(this).load(cardAllFileiconPath).into(cardAllFile);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        PreventKeyboardBlockUtil.getInstance(this).setBtnView(button).register();
    }

    @Override
    public void takeFail(TResult result, String msg) {

    }

    @Override
    public void takeCancel() {

    }
    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type=PermissionManager.checkPermission(TContextWrap.of(this),invokeParam.getMethod());
        if(PermissionManager.TPermissionType.WAIT.equals(type)){
            this.invokeParam=invokeParam;
        }
        return type;
    }

    @Override
    protected void onPause() {
        super.onPause();
        PreventKeyboardBlockUtil.getInstance(this).unRegister();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.cardPoFile:
                //身份证正面
                type = 1;
                showtakephoto();
                break;
            case R.id.cardNeFile:
                //身份证反面
                type = 2;
                showtakephoto();
                break;
            case R.id.cardAllFile:
                //手持身份证
                type = 3;
                showtakephoto();
                break;
            case R.id.button:
                //提交
                if(cardPoFileiconPath == null){
                    Utils.showToast("请上传身份证正面照");
                }else if(cardNeFileiconPath == null){
                    Utils.showToast("请上传身份证反面照");
                }else if(cardAllFileiconPath == null){
                    Utils.showToast("请上传手持身份证照");
                }else if(TextUtils.isEmpty(actName.getText().toString())){
                    Utils.showToast("姓名不能为空");
                }else if(TextUtils.isEmpty(actCard.getText().toString())){
                    Utils.showToast("身份证号不能为空");
                }else {
                    final File cardPoFile = new File(cardPoFileiconPath);
                    final File cardNeFile = new File(cardNeFileiconPath);
                    final File cardAllFile = new File(cardAllFileiconPath);
                    RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                            .addFormDataPart("cardPoFile", cardPoFile.getName(), RequestBody.create(MediaType.parse("image/*"), cardPoFile))
                            .addFormDataPart("cardNeFile", cardNeFile.getName(), RequestBody.create(MediaType.parse("image/*"), cardNeFile))
                            .addFormDataPart("cardAllFile", cardAllFile.getName(), RequestBody.create(MediaType.parse("image/*"), cardAllFile))
                            .addFormDataPart("actName",actName.getText().toString())
                            .addFormDataPart("actCard",actCard.getText().toString())
                            .build();
                    Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).submitAuth(DapinDaoApp.getToken(),requestBody);
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if(response.body()!=null){
                                String jsonStr = null;//把原始数据转为字符串
                                try {
                                    jsonStr = new String(response.body().bytes());
                                    JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                                    if(jsonObject.get("code").getAsInt() == 0){
                                        Toast.makeText(getApplicationContext(),"提交成功",Toast.LENGTH_LONG).show();
                                        DapinDaoApp.LoadUserModel(DapinDaoApp.getToken());
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
                break;
        }
    }


    private void showtakephoto(){
        final MyBottomSheetDialog dialog = new MyBottomSheetDialog(this);
        View box_view = LayoutInflater.from(this).inflate(R.layout.takephoto,null);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);  //←重点在这里，来，都记下笔记
        dialog.setContentView(box_view);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        TextView camera = (TextView) box_view.findViewById(R.id.camera);
        TextView Album = (TextView) box_view.findViewById(R.id.Album);
        TextView cancel_btn = (TextView) box_view.findViewById(R.id.cancel_btn);
        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                File file = new File(getExternalCacheDir(), System.currentTimeMillis() + ".png");
                Uri uri = Uri.fromFile(file);
                int size = Math.min(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
                CropOptions cropOptions = new CropOptions.Builder().setOutputX(size).setOutputX(size).setWithOwnCrop(true).create();
                switch (v.getId()) {
                    //相机
                    case R.id.camera:
                        takePhoto.onPickFromCaptureWithCrop(uri, cropOptions);
                        break;
                    //相册
                    case R.id.Album:
                        //相机获取照片并剪裁
                        takePhoto.onPickFromGalleryWithCrop(uri, cropOptions);
                        break;
                    //取消
                    case R.id.cancel_btn:
                        dialog.dismiss();
                        break;

                }
                dialog.dismiss();
            }
        };

        cancel_btn.setOnClickListener(listener);
        camera.setOnClickListener(listener);
        Album.setOnClickListener(listener);
    }
}
