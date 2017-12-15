package com.hua.demos.activity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hua.R;
import com.hua.main.activity.BaseActivity;

import org.xutils.common.util.LogUtil;

/**
 * 3.2 完全通过代码实现游戏的进入界面
 * Created by Administrator on 2017/12/15.
 */

public class ExerciseDemo3_2Activity extends AppCompatActivity {


    private TextView text2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout = new FrameLayout(this);
        setContentView(frameLayout);

        TextView text1 = new TextView(this);
        text1.setText("在代码中控制UI界面");
        text1.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
        text1.setTextColor(Color.rgb(1,1,1));
        frameLayout.addView(text1);

        text2 = new TextView(this);
        text2.setText("单击进入游戏");
        text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
        text2.setTextColor(Color.rgb(1,1,1));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        text2.setLayoutParams(params);
        frameLayout.addView(text2);

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ExerciseDemo3_2Activity.this)
                        .setTitle("系统提示")
                        .setMessage("游戏有风险,进入需谨慎,真的要进入吗?")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LogUtil.e("进入游戏");
                            }
                        })
                        .setNegativeButton("退出", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LogUtil.e("退出游戏");
                                finish();
                            }
                        })
                        .show();
            }
        });

    }
}
