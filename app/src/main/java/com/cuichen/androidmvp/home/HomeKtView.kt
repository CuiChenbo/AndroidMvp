package com.cuichen.androidmvp.home

import com.cuichen.androidmvp.home.base.BaseView

interface HomeKtView : BaseView {
    fun onResult(datas : MutableList<String>)
}