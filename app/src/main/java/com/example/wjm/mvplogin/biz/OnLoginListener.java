package com.example.wjm.mvplogin.biz;

import com.example.wjm.mvplogin.bean.User;

/**
 * Created by okbuy on 17-1-19.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFail();
}
