package com.example.dapindao.View;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.dapindao.Adapter.Adapter;
import com.example.dapindao.Adapter.ChannelPagerAdapter;
import com.example.dapindao.Interface.OnChannelListener;
import com.example.dapindao.Model.Channel;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.Constants;
import com.example.dapindao.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.Jzvd;
import me.weyye.library.colortrackview.ColorTrackTabLayout;

public class HomeFragment extends Fragment implements View.OnClickListener, OnChannelListener {
    //首页
    private View view;
    @BindView(R.id.tab_channel)
    ColorTrackTabLayout mTabChannel;
    @BindView(R.id.vp_content)
    ViewPager mVpContent;
    @BindView(R.id.iv_operation)
    ImageView ivAddChannel;
    private List<Channel> mSelectedChannels = new ArrayList<>();//已经选择的
    private List<Channel> mUnSelectedChannels = new ArrayList<>();//未选择的
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ChannelPagerAdapter mChannelPagerAdapter;
    private String[] mChannelCodes;
    private Gson mGson = new Gson();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.homepage,container,false);
        ButterKnife.bind(this,view);
        ivAddChannel.setOnClickListener(this);
        ivAddChannel.setOnClickListener(this);
        initUI();
        initChannelData();
        initChannelFragments();
        initListener();
        return view;
    }

    private void initUI(){

    }

    /**
     * 初始化已选频道和未选频道的数据
     */
    private void initChannelData(){
        String selectedChannelJson = Utils.getString(Constants.SELECTED_CHANNEL_JSON, "");
        String unselectChannel = Utils.getString(Constants.UNSELECTED_CHANNEL_JSON, "");
        if (TextUtils.isEmpty(selectedChannelJson) || TextUtils.isEmpty(unselectChannel)){
                //本地没有title
            String[] channels = getResources().getStringArray(R.array.channel);
            String[] channelCodes = getResources().getStringArray(R.array.channel_code);
            //默认添加了全部频道
            for (int i = 0; i < channelCodes.length; i++) {
                String title = channels[i];
                String code = channelCodes[i];
                mSelectedChannels.add(new Channel(title, code));
            }
            selectedChannelJson = mGson.toJson(mSelectedChannels);//将集合转换成json字符串
            KLog.i("selectedChannelJson:" + selectedChannelJson);
            Utils.putString(Constants.SELECTED_CHANNEL_JSON, selectedChannelJson);//保存到sp
        }
        else {
            //之前添加过
            List<Channel> selectedChannel = mGson.fromJson(selectedChannelJson, new TypeToken<List<Channel>>() {
            }.getType());
            List<Channel> unselectedChannel = mGson.fromJson(unselectChannel, new TypeToken<List<Channel>>() {
            }.getType());
            mSelectedChannels.addAll(selectedChannel);
            mUnSelectedChannels.addAll(unselectedChannel);
            Log.e("TAG", "initChannelData: "+ mSelectedChannels.size());
            Log.e("TAG", "initChannelData: "+ mUnSelectedChannels.size());
        }
    }
    /**
     * 初始化已选频道的fragment的集合
     */
    private void initChannelFragments(){

         mChannelCodes = getResources().getStringArray(R.array.channel_code);
        for (Channel channel : mSelectedChannels) {
            if(channel.channelCode.equals("Focuson")){
                FocusonFragment focusonFragment = new FocusonFragment();
                mFragments.add(focusonFragment);
            }
             if(channel.channelCode.equals("recommended")){
                 RecommendedFragment recommendedFragment = new RecommendedFragment();
                 mFragments.add(recommendedFragment);
             }
             if(channel.channelCode.equals("Hot_list")){
                 HotListFragment hotListFragment = new HotListFragment();
                 mFragments.add(hotListFragment);
             }
             if(channel.channelCode.equals("alerts")){
                 AlertsFragment alertsFragment = new AlertsFragment();
                 mFragments.add(alertsFragment);
             }
             if(channel.channelCode.equals("project")){
                 ProjectFragment projectFragment = new ProjectFragment();
                 mFragments.add(projectFragment);
             }
             if(channel.channelCode.equals("Film_critics")){
                 FilmCriticsFragment filmCriticsFragment = new FilmCriticsFragment();
                 mFragments.add(filmCriticsFragment);
             }
             if(channel.channelCode.equals("Large_watch")){
                 LargeWatchFragment largeWatchFragment = new LargeWatchFragment();
                 mFragments.add(largeWatchFragment);
             }
             if(channel.channelCode.equals("activity")){
                 ActivityFragment activityFragment = new ActivityFragment();
                 mFragments.add(activityFragment);
             }
             if(channel.channelCode.equals("shadow_cast")){
                 ShadowCastFragment shadowCastFragment = new ShadowCastFragment();
                 mFragments.add(shadowCastFragment);
             }
             if(channel.channelCode.equals("company")){
                 CompanyFragment companyFragment = new CompanyFragment();
                 mFragments.add(companyFragment);
             }
             if(channel.channelCode.equals("movie")){
                 MovieFragment movieFragment =new MovieFragment();
                 mFragments.add(movieFragment);
             }
             if(channel.channelCode.equals("series")){
                 SeriesFragment seriesFragment = new SeriesFragment();
                 mFragments.add(seriesFragment);
             }
             if(channel.channelCode.equals("workplace")){
                 WorkplaceFragmnet workplaceFragmnet = new WorkplaceFragmnet();
                 mFragments.add(workplaceFragmnet);
             }
             if(channel.channelCode.equals("Box_office")){
                 BoxofficeFragment boxofficeFragment = new BoxofficeFragment();
                 mFragments.add(boxofficeFragment);
             }
             if(channel.channelCode.equals("advertising")){
                 AdvertisingFragment advertisingFragment = new AdvertisingFragment();
                 mFragments.add(advertisingFragment);
             }
             if(channel.channelCode.equals("overseas")){
                 OverseasFragment overseasFragment = new OverseasFragment();
                 mFragments.add(overseasFragment);
             }
             if(channel.channelCode.equals("derivatives")){
                 DerivativesFragment derivativesFragment = new DerivativesFragment();
                 mFragments.add(derivativesFragment);
             }
             if(channel.channelCode.equals("festival")){
                 FilmfestFragment filmfestFragment = new FilmfestFragment();
                 mFragments.add(filmfestFragment);
             }
             if(channel.channelCode.equals("variety")){
                 VarietyFragmnet varietyFragmnet = new VarietyFragmnet();
                 mFragments.add(varietyFragmnet);
             }
             if(channel.channelCode.equals("anime")){
                 AnimeFragment animeFragment = new AnimeFragment();
                 mFragments.add(animeFragment);
             }
             if(channel.channelCode.equals("documentary")){
                 DocumentaryFragment documentaryFragment= new DocumentaryFragment();
                 mFragments.add(documentaryFragment);
             }

         }
        Log.e("TAG", "initChannelFragments: "+mSelectedChannels.size() );
        Log.e("TAG", "initChannelFragments11: "+mFragments.size() );

    }



    private void initListener() {
        mChannelPagerAdapter = new ChannelPagerAdapter(mFragments, mSelectedChannels,getChildFragmentManager());
        mVpContent.setAdapter(mChannelPagerAdapter);
        mVpContent.setOffscreenPageLimit(mSelectedChannels.size());
        mTabChannel.setTabPaddingLeftAndRight(Utils.dip2Px(10), Utils.dip2Px(10));
        mTabChannel.setupWithViewPager(mVpContent);
        mTabChannel.post(new Runnable() {
            @Override
            public void run() {
                //设置最小宽度，使其可以在滑动一部分距离
                ViewGroup slidingTabStrip = (ViewGroup) mTabChannel.getChildAt(0);
                slidingTabStrip.setMinimumWidth(slidingTabStrip.getMeasuredWidth() + ivAddChannel.getMeasuredWidth());
            }
        });

        mVpContent.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当页签切换的时候，如果有播放视频，则释放资源
                Jzvd.releaseAllVideos();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onClick(View view) {
            if(view == ivAddChannel){
                ChannelDialogFragment dialogFragment = ChannelDialogFragment.newInstance(mSelectedChannels, mUnSelectedChannels);
                dialogFragment.setOnChannelListener(this);
                dialogFragment.show(getChildFragmentManager(), "CHANNEL");
                dialogFragment.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        mChannelPagerAdapter.notifyDataSetChanged();
                        mVpContent.setOffscreenPageLimit(mSelectedChannels.size());
                        mTabChannel.setCurrentItem(mTabChannel.getSelectedTabPosition());
                        ViewGroup slidingTabStrip = (ViewGroup) mTabChannel.getChildAt(0);
                        //注意：因为最开始设置了最小宽度，所以重新测量宽度的时候一定要先将最小宽度设置为0
                        slidingTabStrip.setMinimumWidth(0);
                        slidingTabStrip.measure(0, 0);
                        slidingTabStrip.setMinimumWidth(slidingTabStrip.getMeasuredWidth() + ivAddChannel.getMeasuredWidth());
                        //保存选中和未选中的channel
                        Utils.putString(Constants.SELECTED_CHANNEL_JSON, mGson.toJson(mSelectedChannels));
                        Utils.putString(Constants.UNSELECTED_CHANNEL_JSON, mGson.toJson(mUnSelectedChannels));

                    }
                });
            }
    }

    @Override
    public void onItemMove(int starPos, int endPos) {
        listMove(mSelectedChannels, starPos, endPos);
        listMove(mFragments, starPos, endPos);
    }

    @Override
    public void onMoveToMyChannel(int starPos, int endPos) {
        //移动到我的频道
        Channel channel = mUnSelectedChannels.remove(starPos);
        mSelectedChannels.add(endPos, channel);
            if(channel.channelCode.equals("Focuson")){
                FocusonFragment focusonFragment = new FocusonFragment();
                mFragments.add(focusonFragment);
            }
            if(channel.channelCode.equals("recommended")){
                RecommendedFragment recommendedFragment = new RecommendedFragment();
                mFragments.add(recommendedFragment);

            }
            if(channel.channelCode.equals("Hot_list")){
                HotListFragment hotListFragment = new HotListFragment();
                mFragments.add(hotListFragment);

            }
            if(channel.channelCode.equals("alerts")){
                AlertsFragment alertsFragment = new AlertsFragment();
                mFragments.add(alertsFragment);

            }
            if(channel.channelCode.equals("project")){
                ProjectFragment projectFragment = new ProjectFragment();
                mFragments.add(projectFragment);

            }
            if(channel.channelCode.equals("Film_critics")){
                FilmCriticsFragment filmCriticsFragment = new FilmCriticsFragment();
                mFragments.add(filmCriticsFragment);

            }
            if(channel.channelCode.equals("Large_watch")){
                LargeWatchFragment largeWatchFragment = new LargeWatchFragment();
                mFragments.add(largeWatchFragment);

            }
            if(channel.channelCode.equals("activity")){
                ActivityFragment activityFragment = new ActivityFragment();
                mFragments.add(activityFragment);

            }
            if(channel.channelCode.equals("shadow_cast")){
                ShadowCastFragment shadowCastFragment = new ShadowCastFragment();
                mFragments.add(shadowCastFragment);

            }
            if(channel.channelCode.equals("company")){
                CompanyFragment companyFragment = new CompanyFragment();
                mFragments.add(companyFragment);

            }
            if(channel.channelCode.equals("movie")){
                MovieFragment movieFragment =new MovieFragment();
                mFragments.add(movieFragment);

            }
            if(channel.channelCode.equals("series")){
                SeriesFragment seriesFragment = new SeriesFragment();
                mFragments.add(seriesFragment);

            }
            if(channel.channelCode.equals("workplace")){
                WorkplaceFragmnet workplaceFragmnet = new WorkplaceFragmnet();
                mFragments.add(workplaceFragmnet);

            }
            if(channel.channelCode.equals("Box_office")){
                BoxofficeFragment boxofficeFragment = new BoxofficeFragment();
                mFragments.add(boxofficeFragment);

            }
            if(channel.channelCode.equals("advertising")){
                AdvertisingFragment advertisingFragment = new AdvertisingFragment();
                mFragments.add(advertisingFragment);

            }
            if(channel.channelCode.equals("overseas")){
                OverseasFragment overseasFragment = new OverseasFragment();
                mFragments.add(overseasFragment);

            }
            if(channel.channelCode.equals("derivatives")){
                DerivativesFragment derivativesFragment = new DerivativesFragment();
                mFragments.add(derivativesFragment);

            }
            if(channel.channelCode.equals("festival")){
                FilmfestFragment filmfestFragment = new FilmfestFragment();
                mFragments.add(filmfestFragment);

            }
            if(channel.channelCode.equals("variety")){
                VarietyFragmnet varietyFragmnet = new VarietyFragmnet();
                mFragments.add(varietyFragmnet);

            }
            if(channel.channelCode.equals("anime")){
                AnimeFragment animeFragment = new AnimeFragment();
                mFragments.add(animeFragment);

            }
            if(channel.channelCode.equals("documentary")){
                DocumentaryFragment documentaryFragment= new DocumentaryFragment();
                mFragments.add(documentaryFragment);

            }





    }

    @Override
    public void onMoveToOtherChannel(int starPos, int endPos) {
        //移动到推荐频道
        mUnSelectedChannels.add(endPos, mSelectedChannels.remove(starPos));
        mFragments.remove(starPos);


    }

    private void listMove(List datas, int starPos, int endPos) {
        Object o = datas.get(starPos);
        //先删除之前的位置
        datas.remove(starPos);
        //添加到现在的位置
        datas.add(endPos, o);

    }
}
