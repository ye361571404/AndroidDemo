package hua.demo.feature.customview.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

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
    @Bind(R.id.btn_rabbit)
    Button mBtnRabbit;
    @Bind(R.id.btn_parallax_effects)
    Button mBtnParallaxEffects;

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


    @OnClick({R.id.btn_start,R.id.btn_rabbit,R.id.btn_parallax_effects})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                start();
                break;
            case R.id.btn_rabbit:
                goToRabbit();
                break;
            case R.id.btn_parallax_effects:
                parallaxEffects();
                break;
        }
    }

    /**
     * 视差特效
     */
    private void parallaxEffects() {
        startActivity(new Intent(mContext,ParallaxEffectsActivity.class));
    }

    private void goToRabbit() {
        startActivity(new Intent(mContext,RabbitActivity.class));
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
