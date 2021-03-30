package com.cuichen.java_mvp.home.base;

public interface BasePresenter<V extends BaseView> {
    void attach(V view);
    void detach();
}
