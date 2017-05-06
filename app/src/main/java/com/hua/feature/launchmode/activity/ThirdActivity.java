package com.hua.feature.launchmode.activity;

import android.util.Log;

import com.hua.R;
import com.hua.main.activity.BaseActivity;

public class ThirdActivity extends BaseActivity {

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_third;
    }

    @Override
    protected void assignViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        Log.e(TAG, "initData: taskid = " + getTaskId());
    }
}
