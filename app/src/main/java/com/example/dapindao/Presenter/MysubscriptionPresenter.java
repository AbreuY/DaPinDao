package com.example.dapindao.Presenter;

import com.example.dapindao.Interface.MysubscriptionInterface;
import com.example.dapindao.View.MysubscriptionActivity;

public class MysubscriptionPresenter {
    private MysubscriptionActivity activity;
    private MysubscriptionInterface.View view;
    public MysubscriptionPresenter(MysubscriptionInterface.View view,MysubscriptionActivity activity){
        this.activity = activity;
        this.view = view;

    }
}
