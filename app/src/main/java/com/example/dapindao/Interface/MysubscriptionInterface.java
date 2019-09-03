package com.example.dapindao.Interface;

public interface MysubscriptionInterface {
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
        void geSubProjectOnePage(int pageNum,int pageSize,int UserId);
    }
}
