package com.cuichen.java_mvp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cuichen.java_mvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView{


    private TextView tv;
    private ProgressBar progressBar;
    private EditText etName , etPwd;
    private Button btLogin1 , btLogin2;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_java);
        findView();
        mPresenter = new LoginPresenter(this);

        btLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login(etName.getText().toString() , etPwd.getText().toString());
            }
        });

        btLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login();
            }
        });
    }

    private void findView() {
        tv = findViewById(R.id.tvJavaLogin);
        progressBar = findViewById(R.id.progressBarJavaLogin);
        etName = findViewById(R.id.et_nameJavaLogin);
        etPwd = findViewById(R.id.et_pwdJavaLogin);
        btLogin1 = findViewById(R.id.bt_login1JavaLogin);
        btLogin2 = findViewById(R.id.bt_login2JavaLogin);
    }

    @Override
    public void showLoadView() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoadView() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoginError(String error) {
        tv.setTextColor(getResources().getColor(R.color.red));
       tv.setText(error);
    }

    @Override
    public void onSucceed(String result) {
        tv.setTextColor(getResources().getColor(R.color.wx_green));
        tv.setText(result);
    }

    @Override
    public String getName() {
        return etName.getText().toString();
    }

    @Override
    public String getPwd() {
        return etPwd.getText().toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null ) mPresenter.detach();
    }
}