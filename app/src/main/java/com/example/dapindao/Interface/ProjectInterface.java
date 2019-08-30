package com.example.dapindao.Interface;

public interface ProjectInterface {
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
        void getType1Page(int pageNum,int pageSize,String search);//一级专题
    }
}
