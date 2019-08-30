package com.example.dapindao.Interface;

public interface HotListInterface {
    //view
    interface View{
        void succeed();
        void failed();
        void onRefresh();
    }
    //presenter
    interface Presenter{
        void recFront(int type);
    }
}
