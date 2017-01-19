package com.example.wjm.mvplogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.wjm.mvplogin.view.ICommonView;

/**
 * Created by okbuy on 17-1-19.
 */

public class BaseActivity extends AppCompatActivity implements ICommonView {

    private MaterialDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialog = new MaterialDialog.Builder(this).content("Loading...").progress(true, 0).build();
    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        mDialog.dismiss();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
