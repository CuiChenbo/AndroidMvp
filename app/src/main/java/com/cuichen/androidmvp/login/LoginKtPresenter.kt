package com.cuichen.androidmvp.login

import android.os.Handler
import android.text.TextUtils

//直接在构造方法中传递View
class LoginKtPresenter(private var mView: LoginKtView?) {

    fun login(name: String?, pwd: String?) {
        mView!!.showLoadView()
        //模拟网络延时操作
        Handler().postDelayed({
            mView!!.dismissLoadView()
            if (TextUtils.equals(name, "qwe")
                && TextUtils.equals(pwd, "123")
            ) {
                mView!!.onSucceed("登录成功！\nHello、QWE")
            } else {
                mView!!.showLoginError("登录失败！请确认账号和密码")
            }
        }, 2000L)
    }

    fun login() {
        mView!!.showLoadView()
        //模拟网络延时操作
        Handler().postDelayed({
            mView!!.dismissLoadView()
            if (TextUtils.equals(mView!!.getName(), "qwer")
                && TextUtils.equals(mView!!.getPwd(), "1234")
            ) {
                mView!!.onSucceed("登录成功！\nHello、QWER")
            } else {
                mView!!.showLoginError("登录失败！请确认账号和密码")
            }
        }, 2000L)
    }


    fun detach() {
        mView = null
    }
}