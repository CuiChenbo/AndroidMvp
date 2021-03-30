package com.cuichen.androidmvp.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuichen.androidmvp.R
import kotlinx.android.synthetic.main.activity_home_kt.*

class HomeKtActivity : AppCompatActivity()  , HomeKtView{

    var mAdapter : HomeKtAdapter? = null
    var mPresenter : HomeKtPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_kt)
        mPresenter = HomeKtPresenter()
        mPresenter!!.attach(this)
        mPresenter!!.load()

        rv.layoutManager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL ,false)
        mAdapter = HomeKtAdapter(this , mutableListOf())
        rv.adapter = mAdapter
    }

    override fun onResult(datas: MutableList<String>) {
       mAdapter?.setDatas(datas)
    }

    override fun showLoadView() {
        progressBar.visibility = View.VISIBLE
    }

    override fun dismissLoadView() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun showLoadErrorView() {
        Log.i("TAG", "showLoadErrorView: ")
    }
    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detach()
    }
}