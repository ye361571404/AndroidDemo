package com.hua.demos.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;

import com.hua.R;

/**
 * Created by Administrator on 2018/1/3.
 */

public class ExerciseDemo3_22Activity extends AppCompatActivity{

    private Chronometer chronometer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_demo3_22);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setFormat("已用时间: %s");
        chronometer.start();
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(SystemClock.elapsedRealtime() - chronometer.getBase() >= 10000){
                    chronometer.stop();
                }
            }
        });
    }
}
