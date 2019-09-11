package com.example.dapindao.Interface;

public interface MessageCenterInterface
{
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
        void queryUserAppNoticePage(int pagenum,int pagesize);
    }
}
