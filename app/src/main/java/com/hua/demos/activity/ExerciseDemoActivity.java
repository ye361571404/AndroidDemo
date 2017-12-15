package com.hua.demos.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hua.R;
import com.hua.demos.adapter.ExerciseAdapter;
import com.hua.demos.bean.ExerciseBean;
import com.hua.main.activity.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Android 从入门到精通 demo
 * Created by Administrator on 2017/12/15.
 */

public class ExerciseDemoActivity extends BaseActivity implements View.OnClickListener {


    private RecyclerView rvContent;

    private ExerciseBean[] exercises = new ExerciseBean[]{
            new ExerciseBean("3.2 通过代码实现游戏的进入界面",ExerciseDemo3_2Activity.class),
            new ExerciseBean("3.4 自定义View组件实现跟随手指的兔子",ExerciseDemo3_4Activity.class),
            new ExerciseBean("3.6 用表格布局实现登录界面",ExerciseDemo3_6Activity.class)
    };

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_exercise_demo;
    }

    @Override
    protected void assignViews() {
        rvContent = (RecyclerView) findViewById(R.id.rv_content);

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        List<ExerciseBean> exerciseList = Arrays.asList(exercises);
        rvContent.setAdapter(new ExerciseAdapter(this,exerciseList));
        rvContent.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_item:
                ExerciseBean bean = (ExerciseBean) v.getTag();
                Intent intent = new Intent(this, bean.getClazz());
                startActivity(intent);
                break;
        }
    }
}
