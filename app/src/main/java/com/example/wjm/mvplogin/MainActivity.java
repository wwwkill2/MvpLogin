package com.example.wjm.mvplogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wjm.mvplogin.presenter.ILoginPresenter;
import com.example.wjm.mvplogin.presenter.UserLoginPresenter;
import com.example.wjm.mvplogin.view.ILoginView;

public class MainActivity extends BaseActivity implements ILoginView{

    private EditText mEtUserName;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private Button mBtnClear;

    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mEtUserName = (EditText) findViewById(R.id.et_user_name);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnClear = (Button) findViewById(R.id.btn_clear);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.login();
            }
        });
        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.clear();
            }
        });
        mLoginPresenter = new UserLoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return mEtUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserInfo() {
        mEtUserName.getText().clear();
        mEtPassword.getText().clear();
    }
}
