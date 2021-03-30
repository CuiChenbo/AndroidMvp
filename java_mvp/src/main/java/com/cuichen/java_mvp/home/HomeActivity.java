package com.cuichen.java_mvp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cuichen.java_mvp.R;

/**
 * 简易封装基类的MVP
 */
public class HomeActivity extends AppCompatActivity implements HomeView{

    private TextView tv;
    private ProgressBar progressBar;

    private HomePresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_java);
        tv = findViewById(R.id.tvJava);
        progressBar = findViewById(R.id.progressBarJava);

        mPresenter = new HomePresenter();
        mPresenter.attach(this);
        mPresenter.load("HOME");
    }

    @Override
    public void onResult(String result) {
        tv.setText(result);
    }

    @Override
    public void showLoadView() {
      progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoadView() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoadErrorView() {
        tv.setText("ERROR");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detach();
    }
}