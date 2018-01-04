package com.hua.demos.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import com.hua.R;
import com.hua.common.ToastAlone;

/**
 * Created by Administrator on 2018/1/4.
 */

public class ExerciseDemo3_25Activity extends AppCompatActivity {


    private CheckBox checkbox;
    private ImageButton start;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exercise_demo3_25);

        checkbox = (CheckBox) findViewById(R.id.checkbox);
        start = (ImageButton) findViewById(R.id.start);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    start.setVisibility(View.VISIBLE);
                }else{
                    start.setVisibility(View.INVISIBLE);
                }
                start.invalidate();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastAlone.showShortToast("进入游戏");
            }
        });



    }
}
