package com.hua.demos.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.hua.R;
import com.hua.common.ToastAlone;

/**
 * Created by Administrator on 2018/1/3.
 */

public class ExerciseDemo3_23Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_demo3_23);
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastAlone.showShortToast("进入游戏");
            }
        });
    }
}
