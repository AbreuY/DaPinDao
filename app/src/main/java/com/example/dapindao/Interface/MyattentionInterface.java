package com.example.dapindao.Interface;

public interface MyattentionInterface {
    //view
    interface View{
        void succeed();
        void failed();
        void onRefresh();
        void onLoadMore();
        void onNothingData();
    }
    //presenter
    interface Presenter{
        void queryUserFansList(String type,int pagenum,int pagesize);
    }
}
