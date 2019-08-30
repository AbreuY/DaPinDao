package com.example.dapindao.View;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.dapindao.R;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.FoldTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LevelProjectActivity extends BaseActivity {

    @BindView(R.id.text2)
    FoldTextView text;
    @BindView(R.id.parent2)
    FrameLayout parent2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelproject);
        ButterKnife.bind(this);
        text.setText("漫威漫画公司（Marvel Comics）是美国与DC漫画公司（DC Comics）齐名的漫画巨头，它创建于1939年，于1961年正式定名为Marvel，旗下拥有蜘蛛侠、钢铁侠、美国队长、雷神托尔、绿巨人、金刚狼、神奇四侠、恶灵骑士、蚁人等8000多名漫画角色和复仇者联盟、X战警、银河守卫者等超级英雄团队。2009年12月，华特迪士尼公司以42.4亿美元收购Marvel Entertainment Inc.，获得了绝大部分漫画角色的所有权。2010年9月，Marvel宣布其正式中文名称为“漫威”。");
        parent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "父View点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void init() {

    }
}
