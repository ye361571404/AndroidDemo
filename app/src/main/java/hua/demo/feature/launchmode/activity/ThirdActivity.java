package hua.demo.feature.launchmode.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import hua.demo.R;
import hua.demo.main.activity.BaseActivity;

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
