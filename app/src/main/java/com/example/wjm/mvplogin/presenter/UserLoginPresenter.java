package com.example.wjm.mvplogin.presenter;

import android.os.Handler;

import com.example.wjm.mvplogin.bean.User;
import com.example.wjm.mvplogin.biz.IUserBiz;
import com.example.wjm.mvplogin.biz.OnLoginListener;
import com.example.wjm.mvplogin.biz.UserBiz;
import com.example.wjm.mvplogin.view.ILoginView;

/**
 * Created by okbuy on 17-1-19.
 */

public class UserLoginPresenter implements ILoginPresenter {

    // Model
    private IUserBiz mBiz;
    // View
    private ILoginView mView;

    private Handler mHandler;

    public UserLoginPresenter(ILoginView view) {
        mView = view;
        mBiz = new UserBiz();
        mHandler = new Handler();
    }

    @Override
    public void login() {
        mView.showLoading();
        mBiz.login(mView.getUserName(), mView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.hideLoading();
                        mView.showToast("Welcome, " + user.getUserName());
                    }
                });
            }

            @Override
            public void loginFail() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.hideLoading();
                        mView.showToast("Wrong UserName or Password");
                    }
                });
            }
        });
    }

    @Override
    public void clear() {
        mView.clearUserInfo();
    }
}
