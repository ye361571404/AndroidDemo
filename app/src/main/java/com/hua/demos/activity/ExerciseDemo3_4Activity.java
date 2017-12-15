package com.hua.demos.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.hua.R;
import com.hua.demos.views.RabbitView;

/**
 * 自定义View组件,实现跟随手指移动的兔子
 * Created by Administrator on 2017/12/15.
 */

public class ExerciseDemo3_4Activity extends AppCompatActivity{


    private FrameLayout flContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exercise_demo3_4);
        flContent = (FrameLayout) findViewById(R.id.fl_content);

        final RabbitView rabbitView = new RabbitView(this);
        rabbitView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                rabbitView.bitmapX = event.getX();
                rabbitView.bitmapY = event.getY();
                // 重新绘制rabbitView组件
                rabbitView.invalidate();
                return true;
            }
        });

        flContent.addView(rabbitView);
    }
}
