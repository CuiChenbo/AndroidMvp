package com.cuichen.androidmvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cuichen.androidmvp.home.HomeKtActivity
import com.cuichen.androidmvp.login.LoginKtActivity
import com.cuichen.java_mvp.home.HomeActivity
import com.cuichen.java_mvp.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_home.setOnClickListener {
            startActivity(Intent(this@LauncherActivity , HomeKtActivity::class.java))
        }
        bt_login.setOnClickListener{
            startActivity(Intent(this@LauncherActivity , LoginKtActivity::class.java))
        }

        bt_java_home.setOnClickListener {
            startActivity(Intent(this@LauncherActivity , HomeActivity::class.java))
        }
        bt_java_login.setOnClickListener{
            startActivity(Intent(this@LauncherActivity , LoginActivity::class.java))
        }

    }
}