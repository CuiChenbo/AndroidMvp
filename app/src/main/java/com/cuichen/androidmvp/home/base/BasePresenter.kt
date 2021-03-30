package com.cuichen.androidmvp.home.base

interface BasePresenter<V : BaseView?> {
    fun attach(view: V)
    fun detach()
}