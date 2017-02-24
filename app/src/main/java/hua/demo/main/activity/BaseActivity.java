package hua.demo.main.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/2/24.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutRes());
        assignViews();
        setListener();
        initData();
    }


    /**
     * 获取布局文件
     * @return
     */
    protected abstract int getLayoutRes();


    /**
     * 获取控件
     */
    protected abstract void assignViews();

    /**
     * 初始化监听
     */
    protected abstract void setListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();

}
