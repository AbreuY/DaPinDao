package com.example.dapindao.Presenter;

import com.example.dapindao.Interface.MyattentionInterface;
import com.example.dapindao.View.MyattentionActivity;

public class MyattentionPresenter {
    private MyattentionActivity activity;
    private MyattentionInterface.View view;
    public MyattentionPresenter(MyattentionActivity myattentionActivity,MyattentionInterface.View view){
        this.view = view;
        this.activity = myattentionActivity;
    }

}
