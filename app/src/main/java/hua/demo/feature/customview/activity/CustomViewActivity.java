package hua.demo.feature.customview.activity;

import android.view.View;

import butterknife.Bind;
import butterknife.OnClick;
import hua.demo.R;
import hua.demo.feature.customview.view.CustomProgress;
import hua.demo.main.activity.BaseActivity;

/**
 * Created by Administrator on 2017/3/4.
 */

public class CustomViewActivity extends BaseActivity {


    @Bind(R.id.cp_progress)
    CustomProgress mCustomProgress;
    private int max = 200;
    private int progress;


    @Override
    protected int getLayoutRes() {
        return R.layout.custom_view_activity;
    }

    @Override
    protected void assignViews() {
    }

    @Override
    protected void setListener() {
    }

    @Override
    protected void initData() {
        mCustomProgress.setMax(max);
        mCustomProgress.setProgressAndText(0, progress + "%");

    }


    @OnClick({R.id.btn_start})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                start();
                break;
        }
    }


    public void start() {
        progress = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    mCustomProgress.setProgressAndText(progress, progress + "%");
                    progress++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (progress > max) {
                        break;
                    }
                }
            }
        }).start();
    }


}