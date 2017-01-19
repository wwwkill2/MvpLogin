package com.example.wjm.mvplogin.biz;

import com.example.wjm.mvplogin.bean.User;

/**
 * Created by okbuy on 17-1-19.
 */

public class UserBiz implements IUserBiz{
    @Override
    public void login(final String userName, final String password, final OnLoginListener onLoginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("wjm".equals(userName) && "123".equals(password)) {
                    User user = new User();
                    user.setUserName(userName);
                    user.setPassword(password);
                    onLoginListener.loginSuccess(user);
                } else {
                    onLoginListener.loginFail();
                }
            }
        }).start();
    }
}
