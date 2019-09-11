package com.example.dapindao.Interface;

public interface ArticleListsInterface {
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
        void queryArticlePageOwn(int pageNum,int pageSize);
    }
}
