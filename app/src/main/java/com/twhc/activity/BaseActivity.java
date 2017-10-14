package com.twhc.activity;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.twhc.R;


public class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    private ProgressDialog mProgressDialog;
    public boolean isPlayEnable = false, isPlayDone = false, isReplaced = false;

    // Declare all views here
    public ImageView ivPlayerIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        mContext = this;
    }

    protected int setLayoutId() {
        return R.layout.activity_main;
    }



    public void addFragment(Fragment fragment, int containerId) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerId, fragment)
                .commitAllowingStateLoss();
    }

    public void replaceFragment(Fragment fragment, int containerId) {
        isReplaced = true;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commitAllowingStateLoss();
    }

    public void showProgress() {
        showProgress("Loading");
    }

    public void showProgress(String msg) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            dismissProgress();
        }
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    public void dismissProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void setOtherFragment(Fragment fragment) {
        // Do something
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        isReplaced = true;
    }



}
