package com.example.dapindao.View;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;
import com.example.dapindao.Listener.PermissionListener;
import com.example.dapindao.R;
import com.example.dapindao.utils.FileUtils;
import com.jaeger.library.StatusBarUtil;
import com.socks.library.KLog;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author ChayChan
 * @description: 详情页查看图片的activity
 * @date 2017/8/23  11:02
 */

public class ImageViewPagerActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private static final String TAG = ImageViewPagerActivity.class.getSimpleName();
    public static final String IMG_URLS = "mImageUrls";
    public static final String POSITION = "position";
    public PermissionListener mPermissionListener;
    @BindView(R.id.vp_pics)
    ViewPager mVpPics;

    @BindView(R.id.tv_indicator)
    TextView mTvIndicator;

    @BindView(R.id.tv_save)
    TextView mTvSave;

    private List<String> mImageUrls = new ArrayList<String>();
    private List<BigImageFragment> mFragments = new ArrayList<BigImageFragment>();
    private int mCurrentPosition;
    private Map<Integer,Boolean> mDownloadingFlagMap = new HashMap<>();//用于保存对应位置图片是否在下载的标识

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_pager);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        StatusBarUtil.setColor(this,getResources().getColor(R.color.black));
        ButterKnife.bind(this);
        mTvSave.setOnClickListener(this);

        initData();
    }

    private void initData(){
        Intent intent = getIntent();
        mImageUrls = intent.getStringArrayListExtra(IMG_URLS);
        int position = intent.getIntExtra(POSITION, 0);
        mCurrentPosition = position;

        for (int i=0;i<mImageUrls.size();i++) {
            String url = mImageUrls.get(i);
            BigImageFragment imageFragment = new BigImageFragment();

            Bundle bundle = new Bundle();
            bundle.putString(BigImageFragment.IMG_URL, url);
            imageFragment.setArguments(bundle);

            mFragments.add(imageFragment);//添加到fragment集合中
            mDownloadingFlagMap.put(i,false);//初始化map，一开始全部的值都为false
        }

        mVpPics.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mVpPics.addOnPageChangeListener(this);


        mVpPics.setCurrentItem(mCurrentPosition);// 设置当前所在的位置
        setIndicator(mCurrentPosition);//设置当前位置指示
    }

    private void setIndicator(int position) {
        mTvIndicator.setText(position + 1 + "/" + mImageUrls.size());//设置当前的指示
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mCurrentPosition = position;
        ;//页面变化时，设置当前的指示
        setIndicator(mCurrentPosition);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        if(view == mTvSave){
            requestRuntimePermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, new PermissionListener() {
                @Override
                public void onGranted() {
                    //保存图片
                    downloadImg();
                }

                @Override
                public void onDenied(List<String> deniedPermissions) {
                    Toast.makeText(getApplicationContext(),"保存失败，SD卡写入权限被拒绝",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    private void downloadImg() {
        String imgUrl = mImageUrls.get(mCurrentPosition);
        Boolean isDownlading = mDownloadingFlagMap.get(mCurrentPosition);
        if (!isDownlading){
            //如果不是正在下载，则开始下载
            mDownloadingFlagMap.put(mCurrentPosition,true);//更改标识为下载中
            new DownloadImgTask(mCurrentPosition).execute(imgUrl);
        }
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

    /**
     * 申请运行时权限
     */
    public void requestRuntimePermission(String[] permissions, PermissionListener permissionListener) {
        mPermissionListener = permissionListener;
        List<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }

        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissionList.toArray(new String[permissionList.size()]), 1);
        } else {
            permissionListener.onGranted();
        }
    }


    class DownloadImgTask extends AsyncTask<String,Integer,Void>{

        private int mPosition;

        public  DownloadImgTask(int position){
            mPosition = position;
        }

        @Override
        protected Void doInBackground(String... params) {
            String imgUrl = params[0];
            File file = null;
            try {
                FutureTarget<File>  future = Glide
                        .with(ImageViewPagerActivity.this)
                        .load(imgUrl)
                        .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
                file = future.get();

                String filePath = file.getAbsolutePath();

                String destFileName = System.currentTimeMillis() + FileUtils.getImageFileExt(filePath);
                File destFile = new File(FileUtils.getDir(""), destFileName);

                FileUtils.copy(file, destFile);// 保存图片

                // 最后通知图库更新
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                        Uri.fromFile(new File(destFile.getPath()))));
            } catch (Exception e) {
                KLog.e(TAG, e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mDownloadingFlagMap.put(mPosition,false);//下载完成后更改对应的flag
            Toast.makeText(getApplicationContext(),"保存成功，图片所在文件夹:SD卡根路径/TouTiao",Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            KLog.i(TAG,"progress: " + values[0]);
        }
    }


}
