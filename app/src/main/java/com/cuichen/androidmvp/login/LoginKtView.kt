package com.cuichen.androidmvp.login

interface LoginKtView {
    fun showLoadView()
    fun dismissLoadView()
    fun showLoginError(error: String?)
    fun onSucceed(result: String?)
    fun getName(): String?
    fun getPwd(): String?
}