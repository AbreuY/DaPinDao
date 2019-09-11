package com.example.dapindao.Interface;

public interface MycommentsInterface {
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
        void queryOwnCommentPage(int pagenum,int pagesize,String type);
    }
}
