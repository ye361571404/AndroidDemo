package com.hua.feature.launchmode.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import com.hua.R;
import com.hua.main.activity.BaseActivity;

public class FirstActivity extends BaseActivity {


    @BindView(R.id.tv_item)
    TextView tvItem;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_first;
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


    @OnClick(R.id.tv_item)
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.tv_item:
                Intent intent = new Intent(mContext, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
