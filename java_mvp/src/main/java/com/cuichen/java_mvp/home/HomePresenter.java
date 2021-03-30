package com.cuichen.java_mvp.home;

import android.os.Handler;

import com.cuichen.java_mvp.home.base.BasePresenter;


public class HomePresenter implements BasePresenter<HomeView> {
    private HomeView mView;
    @Override
    public void attach(HomeView view) {
        mView = view;
    }

    public void load(String s){
        mView.showLoadView();
        //模拟网络延时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.dismissLoadView();
                mView.onResult(s+" Result");
            }
        }, 2000L);
    }

    @Override
    public void detach() {
       mView = null;
    }
}
