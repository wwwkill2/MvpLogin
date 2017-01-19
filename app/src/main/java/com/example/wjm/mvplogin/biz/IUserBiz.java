package com.example.wjm.mvplogin.biz;

/**
 * Created by okbuy on 17-1-19.
 */

public interface IUserBiz {
    void login(String userName, String password, OnLoginListener onLoginListener);
}
