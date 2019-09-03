package com.example.dapindao.View;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.CommentExpandAdapter;
import com.example.dapindao.Adapter.VideoCommentExpandAdapter;
import com.example.dapindao.Adapter.VideoListAdapter;
import com.example.dapindao.App.DapinDaoApp;
import com.example.dapindao.Model.ArticleDetailsModel;
import com.example.dapindao.Model.Data;
import com.example.dapindao.Model.VedioesDetailModel;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.MyBottomSheetDialog;
import com.example.dapindao.utils.MyJZVideoPlayerStandard;
import com.example.dapindao.utils.Utils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jaeger.library.StatusBarUtil;
import com.sina.weibo.sdk.share.BaseActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class VideoDetailsActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.video_player)
    MyJZVideoPlayerStandard video_player;
    @BindView(R.id.titletv)
    TextView title;
    @BindView(R.id.iv_back)
    ImageView back;//返回
    @BindView(R.id.downloadbtn)
    ImageView downloadbtn;
    private Jzvd.JZAutoFullscreenListener mSensorEventListener;
    private SensorManager mSensorManager;
    private String videopath;
    private int loginUserId;
    @BindView(R.id.detail_page_lv_comment)
    CommentExpandableListView expandableListView;
    @BindView(R.id.conment_tv)
    TextView conment_tv;
    private BottomSheetDialog dialog;
    private VideoCommentExpandAdapter adapter;
    private List<VedioesDetailModel.CommentResultBean.ListBean> commentsList = new ArrayList<>();
    private String secondType;//详细类型
    private String articleUuid;//文章、视频、快讯的uuid
    private int articleUserId ;//文章所属作者的用户id
    private String articleTitle;//标题
    private String articleUuids;
    private String UserName;//个人昵称
    private String articleImgPath;
    private int toUserName;
    private String token;
    private String avatarPath;//头像地址
    private VedioesDetailModel model;
    @BindView(R.id.comments_btn)
    ConstraintLayout comments_btn;
    @BindView(R.id.comments)
    TextView comments;
    @BindView(R.id.detail_page_do_comment)
    TextView bt_comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        setContentView(R.layout.videodetails);
        StatusBarUtil.setColor(this,getResources().getColor(R.color.black));
        ButterKnife.bind(this);
        back.setOnClickListener(this);
        downloadbtn.setOnClickListener(this);
        bt_comment.setOnClickListener(this);
        comments_btn.setOnClickListener(this);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorEventListener = new Jzvd.JZAutoFullscreenListener();
        video_player.setAllControlsVisiblity(GONE, GONE, VISIBLE, GONE, VISIBLE, VISIBLE, GONE);
        video_player.titleTextView.setVisibility(GONE);
        loginUserId = Utils.getShared(getApplicationContext(),"UserId");
        token = Utils.getShared2(getApplicationContext(),"token");
        UserName=(Utils.getShared2(getApplicationContext(),"userName"));
        avatarPath = Utils.getShared2(getApplicationContext(),"avatarPath");

        loaddetails();

    }

    public void loaddetails(){
        Call<VedioesDetailModel> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).getVedioesDetail(getIntent().getStringExtra("id"),getIntent().getStringExtra("articleUuid"),10,loginUserId);
        call.enqueue(new Callback<VedioesDetailModel>() {
            @Override
            public void onResponse(Call<VedioesDetailModel> call, Response<VedioesDetailModel> response) {
                if(response.body()!=null){
                    if(response.body().getCode() == 0){
                        model = new VedioesDetailModel();
                        model.setVedioes(response.body().getVedioes());
                        model.setCommentResult(response.body().getCommentResult());
                        videopath = response.body().getVedioes().getVedioPath();
                        video_player.setUp(response.body().getVedioes().getVedioPath(), "", JzvdStd.SCREEN_WINDOW_NORMAL);
                        Glide.with(getApplicationContext()).load(response.body().getVedioes().getImgPath()).into( video_player.thumbImageView);
                        title.setText(response.body().getVedioes().getTitle());
                        video_player.startVideo();
                        articleUuid = response.body().getVedioes().getUuid();
                        articleTitle = response.body().getVedioes().getTitle();
                        articleImgPath = response.body().getVedioes().getImgPath();
                        comments.setText(""+model.getCommentResult().getTotal());
                        //默认展开所有回复
                        commentsList= model.getCommentResult().getList();
                        adapter = new VideoCommentExpandAdapter(VideoDetailsActivity.this,getApplicationContext(),commentsList);
                        expandableListView.setAdapter(adapter);
                        for(int i = 0; i<commentsList.size(); i++){
                            expandableListView.expandGroup(i);
                        }
                        expandableListView.setOnGroupClickListener((expandableListView, view, groupPosition, l) -> {
                            Log.e("TAG", "onGroupClick: 当前的评论id>>>"+commentsList.get(groupPosition).getId());
                            showReplyDialog(groupPosition,commentsList.get(groupPosition).getId());
                            return true;
                        });
                        expandableListView.setOnChildClickListener((expandableListView, view, groupPosition, childPosition, l) -> {
                            Toast.makeText(getApplicationContext(),"点击了回复",Toast.LENGTH_SHORT).show();
                            return false;
                        });
                        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                            @Override
                            public void onGroupExpand(int groupPosition) {
                                //toast("展开第"+groupPosition+"个分组");

                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<VedioesDetailModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorEventListener);
        Jzvd.releaseAllVideos();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(mSensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onClick(View view) {
        if(view == back){
            finish();
        }
        if(view == downloadbtn){
            Data.sampleUrls.add(videopath);
        }
        if(view ==bt_comment){
            showCommentDialog();
        }
    }



    /**
     * by moos on 2018/04/20
     * func:弹出回复框
     */
    private void showReplyDialog(final int position,final  String oneCommentId){
        dialog = new BottomSheetDialog(this,R.style.BottomSheetEdit);
        View commentView = LayoutInflater.from(this).inflate(R.layout.comment_dialog_layout,null);
        final EditText commentText = (EditText) commentView.findViewById(R.id.dialog_comment_et);
        final Button bt_comment = (Button) commentView.findViewById(R.id.dialog_comment_bt);
        commentText.setHint("回复 " + commentsList.get(position).getUserName() + " 的评论:");
        dialog.setContentView(commentView);
        bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String replyContent = commentText.getText().toString().trim();
                if(!TextUtils.isEmpty(replyContent)){
                    dialog.dismiss();
                    Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).saveComment(token,"2",getIntent().getStringExtra("secondType"),articleUuid,articleUserId,articleTitle,articleImgPath,replyContent,null,toUserName,oneCommentId);
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response){
                            if(response.body()!=null){
                                try {
                                    String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                                    JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                                    if(jsonObject.get("code").getAsInt() == 0){
                                        VedioesDetailModel.CommentResultBean.ListBean.SubListBean detailBean = new VedioesDetailModel.CommentResultBean.ListBean.SubListBean(UserName,replyContent);
                                        adapter.addTheReplyData(detailBean, position);
                                        expandableListView.expandGroup(position);
                                        Toast.makeText(getApplicationContext(),"回复成功",Toast.LENGTH_SHORT).show();
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

                }else {
                    Toast.makeText(getApplicationContext(),"回复内容不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
        commentText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!TextUtils.isEmpty(charSequence) && charSequence.length()>2){
                    bt_comment.setBackgroundColor(Color.parseColor("#FFB568"));
                }else {
                    bt_comment.setBackgroundColor(Color.parseColor("#D8D8D8"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dialog.show();
    }

    private void showCommentDialog(){
        dialog = new MyBottomSheetDialog(this,R.style.BottomSheetEdit);
        View commentView = LayoutInflater.from(this).inflate(R.layout.comment_dialog_layout,null);
        final EditText commentText = (EditText) commentView.findViewById(R.id.dialog_comment_et);
        final Button bt_comment = (Button) commentView.findViewById(R.id.dialog_comment_bt);
        dialog.setContentView(commentView);
        /**
         * 解决bsd显示不全的情况
         */
        View parent = (View) commentView.getParent();
        BottomSheetBehavior behavior = BottomSheetBehavior.from(parent);
        commentView.measure(0,0);
        behavior.setPeekHeight(commentView.getMeasuredHeight());

        bt_comment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String commentContent = commentText.getText().toString().trim();
                if(!TextUtils.isEmpty(commentContent)){

                    //commentOnWork(commentContent);
                    dialog.dismiss();
                    Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).saveComment(token,"1",getIntent().getStringExtra("secondType"),articleUuid,articleUserId,articleTitle,articleImgPath,commentContent,null,toUserName,null);
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if(response.body()!=null){
                                try {
                                    String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                                    JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                                    if(jsonObject.get("code").getAsInt() == 0){
                                        VedioesDetailModel.CommentResultBean.ListBean detailBean = new VedioesDetailModel.CommentResultBean.ListBean(avatarPath,UserName, commentContent,Utils.getData(), DapinDaoApp.getUserId());
                                        adapter.addTheCommentData(detailBean);
                                        loaddetails();
                                        Toast.makeText(getApplicationContext(),"评论成功",Toast.LENGTH_SHORT).show();
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


                }else {
                    Toast.makeText(getApplicationContext(),"评论内容不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
        commentText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!TextUtils.isEmpty(charSequence) && charSequence.length()>2){
                    bt_comment.setBackgroundColor(Color.parseColor("#FFB568"));
                }else {
                    bt_comment.setBackgroundColor(Color.parseColor("#D8D8D8"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dialog.show();
    }
}
