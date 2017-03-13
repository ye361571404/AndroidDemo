package hua.demo.feature.launchmode.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.OnClick;
import hua.demo.R;
import hua.demo.main.activity.BaseActivity;

/**
 * Activity 启动模式demo
 */
public class LaunchModeActivity extends BaseActivity {


    @Bind(R.id.btn_single_instance)
    Button btnSingleInstance;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_launch_mode;
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


    @OnClick(R.id.btn_single_instance)
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_single_instance:
                Intent intent = new Intent(mContext, FirstActivity.class);
                startActivity(intent);
            break;
        }
    }
}
