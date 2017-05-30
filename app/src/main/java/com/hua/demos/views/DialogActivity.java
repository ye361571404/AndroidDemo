package com.hua.demos.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hua.R;
import com.hua.main.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends BaseActivity {


    @BindView(R.id.tv_dialog01)
    TextView tvDialog01;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_dialog;
    }

    @Override
    protected void assignViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.tv_dialog01)
    public void onClick() {
        LoadingDialog loadingDialog = new LoadingDialog(this);
        loadingDialog.show();
    }
}
