package hua.demo.feature.customview.activity;

import android.view.View;
import android.widget.Button;

import hua.demo.R;
import hua.demo.feature.customview.view.CustomProgress;
import hua.demo.main.activity.BaseActivity;

/**
 * Created by Administrator on 2017/3/4.
 */

public class CustomViewActivity extends BaseActivity implements View.OnClickListener {


    private CustomProgress mCustomProgress;

    private int max = 100;
    private int progress;
    private Button mBtnStart;

    @Override
    protected int getLayoutRes() {
        return R.layout.custom_view_activity;
    }

    @Override
    protected void assignViews() {
        mCustomProgress = (CustomProgress) findViewById(R.id.cp_progress);
        mBtnStart = (Button) findViewById(R.id.btn_start);
    }

    @Override
    protected void setListener() {
        mBtnStart.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mCustomProgress.setMax(max);
        mCustomProgress.setProgressAndText(0, progress + "%");

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_start:
                start();
                break;
        }
    }

    private void start() {
        progress = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    mCustomProgress.setProgressAndText(progress, progress + "%");
                    progress++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(progress > 100){
                        break;
                    }
                }
            }
        }).start();
    }
}
