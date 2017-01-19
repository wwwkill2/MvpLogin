package com.example.wjm.mvplogin.view;

/**
 * Created by okbuy on 17-1-19.
 */

public interface ILoginView extends ICommonView{
    String getUserName();
    String getPassword();
    void clearUserInfo();
}
