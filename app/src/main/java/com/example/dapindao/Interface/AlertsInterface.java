package com.example.dapindao.Interface;

public interface AlertsInterface {
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
        void recFront(int type,int pageNum,int pageSize);
    }
}
