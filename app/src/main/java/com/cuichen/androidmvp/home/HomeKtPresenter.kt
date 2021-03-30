package com.cuichen.androidmvp.home

import android.os.Handler
import com.cuichen.androidmvp.DataUtils
import com.cuichen.androidmvp.home.base.BasePresenter

/**
 * Author: "ChenboCui"
 * Date: 2021/3/30
 */
class HomeKtPresenter : BasePresenter<HomeKtView> {
    var mView: HomeKtView? = null
    override fun attach(view: HomeKtView) {
        mView = view
    }

    fun load(){
        mView?.showLoadView()
        Handler().postDelayed(object : Runnable {
            override fun run() {
                mView!!.dismissLoadView()
                mView!!.onResult(DataUtils.getData())
            }
        }, 2000L)
    }

    override fun detach() {
        mView = null
    }
}