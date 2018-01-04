package com.hua.demos.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hua.R;


/**
 * Created by Administrator on 2018/1/4.
 */

public class ExerciseDemo3_26Activity extends AppCompatActivity {


    private TextView tvTitle;
    private ImageView ivShoe1;
    private ImageView ivShoe2;
    private ImageView ivShoe3;
    private Button btnStart;
    private int[] imgIds = new int[]{R.drawable.shoe_default,R.drawable.shoe_ok,R.drawable.shoe_sorry};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_demo3_26);

        initView();
        setListener();
        reset();

    }

    private void reset() {

        for (int i = 0; i < 3; i++) {
            int temp = imgIds[i];
            int index = (int) (Math.random() * 2);
            imgIds[i] = imgIds[index];
            imgIds[index] = temp;
        }

    }

    private void setListener() {
        ivShoe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRight(v,0);
            }
        });

        ivShoe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRight(v,1);
            }
        });

        ivShoe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRight(v,2);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                ivShoe1.setImageResource(R.drawable.shoe_default);
                ivShoe2.setImageResource(R.drawable.shoe_default);
                ivShoe3.setImageResource(R.drawable.shoe_default);

                ivShoe1.setAlpha(1.0f);
                ivShoe2.setAlpha(1.0f);
                ivShoe3.setAlpha(1.0f);

                tvTitle.setText(getString(R.string.title));


            }
        });

    }

    private void isRight(View v, int i) {
        ivShoe1.setImageResource(imgIds[0]);
        ivShoe2.setImageResource(imgIds[1]);
        ivShoe3.setImageResource(imgIds[2]);

        ivShoe1.setAlpha(0.5f);
        ivShoe2.setAlpha(0.5f);
        ivShoe3.setAlpha(0.5f);

        ImageView iv = (ImageView) v;
        iv.setAlpha(1.0f);

        if (imgIds[i] == R.drawable.shoe_ok) {
            tvTitle.setText("恭喜你,猜对了");
        }else{
            tvTitle.setText("sorry,猜错了");
        }

    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivShoe1 = (ImageView) findViewById(R.id.iv_shoe1);
        ivShoe2 = (ImageView) findViewById(R.id.iv_shoe2);
        ivShoe3 = (ImageView) findViewById(R.id.iv_shoe3);
        btnStart = (Button) findViewById(R.id.btn_start);

    }
}
