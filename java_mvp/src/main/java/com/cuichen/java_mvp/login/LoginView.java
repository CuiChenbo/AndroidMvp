package com.cuichen.java_mvp.login;

public
interface LoginView {
    void showLoadView();
    void dismissLoadView();
    void showLoginError(String error);
    void onSucceed(String result);

    String getName();
    String getPwd();
}
