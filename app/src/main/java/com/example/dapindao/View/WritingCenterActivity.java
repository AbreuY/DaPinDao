package com.example.dapindao.View;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.R;
import com.example.dapindao.WebEditorTools.ChooseDialog;
import com.example.dapindao.WebEditorTools.ChooseDialogData;
import com.example.dapindao.WebEditorTools.EditToolAdapter;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.CommonUtil;
import com.example.dapindao.utils.ImageUtils;
import com.example.dapindao.utils.MyGlideEngine;
import com.example.dapindao.utils.SDCardUtil;
import com.example.dapindao.utils.Utils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hyb.library.PreventKeyboardBlockUtil;
import com.sendtion.xrichtext.RichTextEditor;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dapindao.utils.Utils.showToast;

public class WritingCenterActivity extends AppCompatActivity implements View.OnClickListener,TakePhoto.TakeResultListener, InvokeListener {


    @BindView(R.id.imgPath)
    ImageView imgPath;//封面
    @BindView(R.id.title)
    EditText title;//标题
    @BindView(R.id.introduction)
    EditText introduction;//简介
    @BindView(R.id.iv_back)
    TextView iv_back;//返回
    @BindView(R.id.simbit)
    TextView simbit;//发布
    @BindView(R.id.view)
    RelativeLayout view;
    @BindView(R.id.action_insert_image)
    ImageView action_insert_image;//插入图片
    private TakePhoto takePhoto;
    public InvokeParam invokeParam;
    private String token;
    private String iconPath;
    private String path;
    @BindView(R.id.richEditor)
    RichEditorNew richEditor;
    @BindView(R.id.gvList)
    GridView gvList;
    @BindView(R.id.tools)
    FrameLayout tools;
    private EditToolAdapter editToolAdapter;
    private Context mContext;
    private int code =1;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.writingcenter);
        mContext = WritingCenterActivity.this;
        ButterKnife.bind(this);
        token = Utils.getShared2(getApplicationContext(),"token");
        verifyStoragePermissions(this);
        initView();
        initListener();


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

    private void initView(){
        iv_back.setOnClickListener(this);
        simbit.setOnClickListener(this);
        imgPath.setOnClickListener(this);
        action_insert_image.setOnClickListener(this);

        richEditor.setHint("请输入内容");
        richEditor.setPadding(10, 10, 10, 10);
        editToolAdapter = new EditToolAdapter(this);
        gvList.setAdapter(editToolAdapter);

    }

    private void initListener() {
        richEditor.setOnTextChangeListener(new RichEditorNew.OnTextChangeNewListener() {
            @Override
            public void onTextChange(String text) {

            }
        });

        richEditor.setOnConsoleMessageListener(new RichEditorNew.OnConsoleMessageListener() {
            @Override
            public void onTextChange(String message, int lineNumber, String sourceID) {
                //控制台打印消息 也可以传值
                if (message != null && message.contains("|")) {
                    Toast.makeText(getApplicationContext(), "message:" + message, Toast.LENGTH_SHORT).show();
                }
                Log.i("TAG", "message:" + message);
            }
        });


        gvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tools.setVisibility(View.GONE);
                ChooseDialogData item = editToolAdapter.getItem(position);
                switch (ChooseDialog.Type.valueOf(item.des)) {
                    case File:
                        insertFile();
                        break;
                    case Audio:
                        insertAudio();
                        break;
                    case Video:
                        insertVideo();
                        break;
                    case TextColor:
                        ChooseDialog.show(mContext, ChooseDialog.Type.TextColor, new ChooseDialog.OnItemClick() {
                            @Override
                            public void click(int position, ChooseDialogData data) {
                                richEditor.setTextColor((int) data.params);
                            }
                        });
                        break;
                    case TextBackgroundColor:
                        ChooseDialog.show(mContext, ChooseDialog.Type.TextBackgroundColor, new ChooseDialog.OnItemClick() {
                            @Override
                            public void click(int position, ChooseDialogData data) {
                                richEditor.setTextBackgroundColor((int) data.params);
                            }
                        });
                        break;

                    case Heading:
                        ChooseDialog.show(mContext, ChooseDialog.Type.Heading, new ChooseDialog.OnItemClick() {
                            @Override
                            public void click(int position, ChooseDialogData data) {
                                richEditor.setFontSize((int) data.params);
                            }
                        });
                        break;
                    case Image:
                        insertImage();
                        break;

                    case InsertLink:

                        break;
                    case NewLine:
                        richEditor.setNewLine();
                        break;
                    case Blod:
                        richEditor.setBold();
                        break;
                    case Subscript:
                        richEditor.setSubscript();
                        break;
                    case Superscript:
                        richEditor.setSuperscript();
                        break;

                    case Strikethrough:
                        richEditor.setStrikeThrough();
                        break;
                    case Underline:
                        richEditor.setUnderline();
                        break;
                    case JustifyLeft:
                        richEditor.setAlignLeft();
                        break;
                    case JustifyCenter:
                        richEditor.setAlignCenter();
                        break;
                    case JustifyRight:
                        richEditor.setAlignRight();
                    case Blockquote:
                        richEditor.setBlockquote();
                        break;
                    case Undo:
                        richEditor.undo();
                        break;
                    case Redo:
                        richEditor.redo();
                        break;
                    case Indent:
                        richEditor.setIndent();
                        break;
                    case Outdent:
                        richEditor.setOutdent();
                        break;
                    case Checkbox:
                        richEditor.insertTodo();
                        break;
                    case FontSize:
                        // TODO
                        break;
                    case UnorderedList:
                        richEditor.setBullets();
                        break;
                    case OrderedList:
                        richEditor.setNumbers();
                        break;
                    default:
                        break;
                }
            }
        });
    }




    private void insertFile() {
    //插入文件
    }
    private void insertAudio() {
        //默认调用 也可以自定义insertAudio(String audioUrl, String custom)
      //  richEditor.insertAudio(TEST_VIDEO_URL);
    }
    private void insertVideo() {
       // richEditor.insertVideo(TEST_VIDEO_URL);
    }
    public void insertImage() {
        code =2;
        takePhoto.onPickFromGallery();

    }

    public void openTools(View view) {
        tools.setVisibility(View.VISIBLE);
    }
    public void closeTools(View view) {
        tools.setVisibility(View.GONE);
    }
    public void getHtmlCode(View view) {
        startShow(false);
    }

    /**
     * 模拟发布内容，然后回来展示，并新增一些新事件
     *
     * @param view
     */
    public void publish(View view) {
        startShow(true);
    }

    public void startShow(Boolean isPublish) {
        Intent intent = new Intent(mContext, ShowHtmlActivity.class);
        String html = richEditor.getHtml();
        intent.putExtra("html", html);
        intent.putExtra("isPublish", isPublish);
        startActivity(intent);
        Log.e("TAG", "startShow:"+html );


    }




    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.simbit:
                try {
                    if(iconPath == null){
                        Toast.makeText(getApplicationContext(),"请上传封面图",Toast.LENGTH_LONG).show();
                    }else if(TextUtils.isEmpty(title.getText().toString())){
                        Toast.makeText(getApplicationContext(),"标题不能为空",Toast.LENGTH_LONG).show();
                    }else if(TextUtils.isEmpty(introduction.getText().toString())){
                        Toast.makeText(getApplicationContext(),"简介不能为空",Toast.LENGTH_LONG).show();
                    }else if(richEditor.getHtml().isEmpty()){
                        Toast.makeText(getApplicationContext(),"内容不能为空",Toast.LENGTH_LONG).show();
                    }else {
                        saveOrPublishArticle();
                    }

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.imgPath:
                //上传封面
                File file = new File(getExternalCacheDir(), System.currentTimeMillis() + ".png");
                Uri uri = Uri.fromFile(file);
                CropOptions cropOptions = new CropOptions.Builder().setOutputX(600).setOutputY(300).setWithOwnCrop(true).create();
                takePhoto.onPickFromGalleryWithCrop(uri, cropOptions);
                break;
            case R.id.action_insert_image:
                insertImage();
                break;
        }
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



    //文件上传
    private String uploadImgToOSSAPP(String imgpath){
        final File file = new File(imgpath);
        Log.e("TAG", "uploadImgToOSSAPP: "+imgpath );
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).uploadImgToOSSAPP(token,part);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    String jsonStr = null;//把原始数据转为字符串
                    try {
                        jsonStr = new String(response.body().bytes());
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                          path = jsonObject.get("imgPath").getAsString();
                            if(code ==2){
                                richEditor.insertImage(path);
                                code = 1;
                            }
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

        return path;
    }

    /**
     * 关闭软键盘
     */
    private void closeSoftKeyInput(){
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        //boolean isOpen=imm.isActive();//isOpen若返回true，则表示输入法打开
        if (imm != null && imm.isActive() && getCurrentFocus() != null){
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            //imm.hideSoftInputFromInputMethod();//据说无效
            //imm.hideSoftInputFromWindow(et_content.getWindowToken(), 0); //强制隐藏键盘
            //如果输入法在窗口上已经显示，则隐藏，反之则显示
            //imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    @Override
    public void takeSuccess(TResult result) {
        iconPath = result.getImage().getOriginalPath();
        if(code != 2){
            Glide.with(this).load(iconPath).into(imgPath);
        }
        uploadImgToOSSAPP(iconPath);


    }

    @Override
    protected void onResume() {
        super.onResume();
        PreventKeyboardBlockUtil.getInstance(this).setBtnView(richEditor).register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        PreventKeyboardBlockUtil.getInstance(this).unRegister();
    }

    //发表文章
    private void saveOrPublishArticle() throws UnsupportedEncodingException {
        final File file = new File(iconPath);
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/*"), file))
                .addFormDataPart("artTypeId","1")
                .addFormDataPart("isAdment","0")
                .addFormDataPart("saveStatus","2")
                .addFormDataPart("isTime","0")
                .addFormDataPart("title",title.getText().toString())
                .addFormDataPart("content",URLEncoder.encode(richEditor.getHtml(),"UTF-8"))
                .addFormDataPart("introduction",introduction.getText().toString())
                .build();
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).saveOrPublishArticle(token,requestBody);
        Log.e("TAG", "saveOrPublishArticle: "+token );
        Log.e("TAG", "saveOrPublishArticle: "+richEditor.getHtml());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    String jsonStr = null;//把原始数据转为字符串
                    try {
                        jsonStr = new String(response.body().bytes());
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            Toast.makeText(getApplicationContext(),"发布成功",Toast.LENGTH_LONG).show();
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
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    /**
     * 在对sd卡进行读写操作之前调用这个方法
     * Checks if the app has permission to write to device storage
     * If the app does not has permission then the user will be prompted to grant permissions
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }
}
