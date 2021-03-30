package com.cuichen.java_mvp.login;

import android.os.Handler;
import android.text.TextUtils;

import com.cuichen.java_mvp.home.HomeView;
import com.cuichen.java_mvp.home.base.BasePresenter;


public class LoginPresenter {
    private LoginView mView;
    public LoginPresenter(LoginView view) {
        mView = view;
    }

    public void login(String name , String pwd){
        mView.showLoadView();
        //模拟网络延时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.dismissLoadView();
                if (TextUtils.equals(name , "qwe")
                        && TextUtils.equals(pwd , "123")){
                    mView.onSucceed("登录成功！\nHello、QWE");
                }else {
                    mView.showLoginError("登录失败！请确认账号和密码");
                }
            }
        }, 2000L);
    }

    public void login(){
        mView.showLoadView();
        //模拟网络延时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.dismissLoadView();
                if (TextUtils.equals(mView.getName() , "qwer")
                        && TextUtils.equals(mView.getPwd() , "1234")){
                    mView.onSucceed("登录成功！\nHello、QWER");
                }else {
                    mView.showLoginError("登录失败！请确认账号和密码");
                }
            }
        }, 2000L);
    }

    public void detach() {
       mView = null;
    }
}
