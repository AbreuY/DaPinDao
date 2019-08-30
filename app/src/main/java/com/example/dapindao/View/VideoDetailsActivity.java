package com.example.dapindao.View;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.VideoListAdapter;
import com.example.dapindao.Model.Data;
import com.example.dapindao.Model.VedioesDetailModel;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.MyJZVideoPlayerStandard;
import com.jaeger.library.StatusBarUtil;
import com.sina.weibo.sdk.share.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        setContentView(R.layout.videodetails);
        StatusBarUtil.setColor(this,getResources().getColor(R.color.black));
        ButterKnife.bind(this);
        back.setOnClickListener(this);
        downloadbtn.setOnClickListener(this);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorEventListener = new Jzvd.JZAutoFullscreenListener();
        video_player.setAllControlsVisiblity(GONE, GONE, VISIBLE, GONE, VISIBLE, VISIBLE, GONE);
        video_player.titleTextView.setVisibility(GONE);
        loaddetails();

    }

    private void loaddetails(){
        Call<VedioesDetailModel> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).getVedioesDetail(getIntent().getStringExtra("id"));
        call.enqueue(new Callback<VedioesDetailModel>() {
            @Override
            public void onResponse(Call<VedioesDetailModel> call, Response<VedioesDetailModel> response) {
                if(response.body()!=null){
                    if(response.body().getCode() == 0){
                        videopath = response.body().getVedioes().getVedioPath();
                        video_player.setUp(response.body().getVedioes().getVedioPath(), "", JzvdStd.SCREEN_WINDOW_NORMAL);
                        Glide.with(getApplicationContext()).load(response.body().getVedioes().getImgPath()).into( video_player.thumbImageView);
                        title.setText(response.body().getVedioes().getTitle());
                        video_player.startVideo();
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
    }
}
