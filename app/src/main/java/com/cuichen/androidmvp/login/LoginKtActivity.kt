package com.cuichen.androidmvp.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cuichen.androidmvp.R
import kotlinx.android.synthetic.main.activity_login_kt.*

class LoginKtActivity : AppCompatActivity(), LoginKtView {


    private var mPresenter: LoginKtPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_kt)

        mPresenter = LoginKtPresenter(this)
        bt_login1!!.setOnClickListener {
            mPresenter!!.login(
                et_name!!.text.toString(),
                et_pwd!!.text.toString()
            )
        }
        bt_login2!!.setOnClickListener { mPresenter!!.login() }
    }


    override fun showLoadView() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun dismissLoadView() {
        progressBar!!.visibility = View.GONE
    }

    override fun showLoginError(error: String?) {
        tv!!.setTextColor(resources.getColor(R.color.red))
        tv!!.text = error
    }

    override fun onSucceed(result: String?) {
        tv!!.setTextColor(resources.getColor(R.color.wx_green))
        tv!!.text = result
    }

    override fun getName(): String {
        return et_name!!.text.toString()
    }

    override fun getPwd(): String {
        return et_pwd!!.text.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null) mPresenter!!.detach()
    }
}