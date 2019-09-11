package com.example.dapindao.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.App.DapinDaoApp;
import com.example.dapindao.Model.FilePathModel;
import com.example.dapindao.Model.publicModel;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.MyBottomSheetDialog;
import com.example.dapindao.utils.Utils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.makeramen.roundedimageview.RoundedImageView;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalCenterActivity extends BaseActivity implements View.OnClickListener,TakePhoto.TakeResultListener, InvokeListener {

    @BindView(R.id.back)
    ImageView back;//返回
    @BindView(R.id.take_photo)
    RelativeLayout take_photo;//更换头像
    private TakePhoto takePhoto;
    private File file;
    @BindView(R.id.roundedImageView)
    RoundedImageView roundedImageView;
    @BindView(R.id.Introduction)
    EditText Introduction;//个人简介
    public InvokeParam invokeParam;
    private String token;
    private String avatarPath;//头像地址
    @BindView(R.id.userName)
    TextView userName;//个人昵称
    @BindView(R.id.userName_btn)
    RelativeLayout userName_btn;//设置个人昵称
    @BindView(R.id.certification_lin)
    RelativeLayout certification_lin;//身份认证
    @BindView(R.id.isAuth)
            TextView isAuth;//是否认证
    private String isAuths;
    int REQUEST_CODE = 0;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalcenter);
        token = Utils.getShared2(getApplicationContext(),"token");
        avatarPath =  Utils.getShared2(getApplicationContext(),"avatarPath");
        isAuths = Utils.getShared2(getApplicationContext(),"isAuth");
        ButterKnife.bind(this);
        initUI();
        initEvent();
        initData();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initUI();
    }

    private void initUI(){
        if(isAuths.equals("0")){
            isAuth.setText("未认证");
            certification_lin.setEnabled(true);
        }
        if(isAuths.equals("1")){
            isAuth.setText("已认证");
            certification_lin.setEnabled(false);
        }
        if(isAuths.equals("2")){
            isAuth.setText("审核中");
            certification_lin.setEnabled(false);
        }
    }
    private void initData(){
        if(avatarPath.equals("")){
            roundedImageView.setImageDrawable(null);
        }else {
            Glide.with(this).load(avatarPath).into(roundedImageView);
        }
        if(Utils.getShared2(getApplicationContext(),"userName").equals("")){
            userName.setText("设置个人昵称");
        }else {
            userName.setText(Utils.getShared2(getApplicationContext(),"userName"));
        }
    }
    private void initEvent(){
        back.setOnClickListener(this);
        take_photo.setOnClickListener(this);
        userName_btn.setOnClickListener(this);
        certification_lin.setOnClickListener(this);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    userName.setText(data.getStringExtra("username"));
                }
            }
        }
    }


    @Override
    protected void init() {

    }

    @Override
    public void onClick(View view) {

        if(view == back){
            Call<ResponseBody> call2 = HttpHelper.getInstance().create(DaPinDaoAPI.class).updateBasicInfo(DapinDaoApp.getToken(),"",Introduction.getText().toString(),"");
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
        if(view == take_photo){
            //头像
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
                    CropOptions cropOptions = new CropOptions.Builder().setOutputX(size).setOutputX(size).setWithOwnCrop(false).create();
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
        if(view == userName_btn){
            //设置个人昵称
            intent = new Intent(getApplicationContext(),NickNameActivity.class);
            intent.putExtra("username",userName.getText().toString());
            startActivityForResult(intent, REQUEST_CODE);

        }

        if(view == certification_lin){
            intent = new Intent(getApplicationContext(),CertificationActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void takeSuccess(TResult result) {
        String iconPath = result.getImage().getOriginalPath();
        file = new File(iconPath);
        Upload(iconPath);
        Glide.with(this).load(iconPath).into(roundedImageView);
    }


    private void Upload(String realFilePath) {
        final File file = new File(realFilePath);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        Call<FilePathModel> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).updatePhoto(token, part);
        call.enqueue(new Callback<FilePathModel>() {
            @Override
            public void onResponse(Call<FilePathModel> call, Response<FilePathModel> response) {
                if (response.body() != null) {
                    if (response.body().getCode()==0) {
                        avatarPath = response.body().getFilePath();
                        DapinDaoApp.LoadUserModel(token);
                        Toast.makeText(getApplicationContext(), "更换头像成功", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(),response.body().getMsg(),Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<FilePathModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
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
    /** * 获取TakePhoto实例 * @return */
    public TakePhoto getTakePhoto(){
        if (takePhoto==null){
            takePhoto= (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this,this));
        }
        //设置压缩规则，最大500kb
        takePhoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(500 * 1024).create(), true);
        return takePhoto;
    }
}
