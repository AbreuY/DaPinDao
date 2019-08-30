package com.example.dapindao.View;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.example.dapindao.R;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.sina.weibo.sdk.utils.UIUtils;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ChayChan
 * @description: 展示大图的fragment
 * @date 2017/8/23  10:42
 */

public class BigImageFragment extends Fragment {

    @BindView(R.id.pv_pic)
    PhotoView mIvPic;

    @BindView(R.id.progressView)
    RoundedImageView mCircleProgressView;
    public static final String IMG_URL = "imgUrl";
    public View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_big_image,container,false);
        ButterKnife.bind(this,view);
        initListener();
        loadData();
        mCircleProgressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        return view;
    }
    private void initListener(){
        mIvPic.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView view, float x, float y) {
                getActivity().finish();
            }
        });
    }

    private void loadData(){
        String imgUrl = getArguments().getString(IMG_URL);
        Glide.with(getActivity())
                .load(imgUrl)
                .into(mCircleProgressView);
    }
}
