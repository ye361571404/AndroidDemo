package com.hua.demos.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hua.R;
import com.hua.common.ToastAlone;

/**
 * 3.14 单选按钮的简单使用
 *
 * Created by Administrator on 2017/12/15.
 */

public class ExerciseDemo3_14Activity extends AppCompatActivity{


    private RadioGroup radioGroup;
    private Button btnCommit;
    private RadioButton rbMan;
    private RadioButton rbWoman;
    private CheckBox cbLike1;
    private CheckBox cbLike2;
    private CheckBox cbLike3;
    private Button btnCommit2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_demo3_14);

        radioButtons();
        checkBox();



    }

    /**
     * 多选框
     */
    private void checkBox() {
        cbLike1 = (CheckBox) findViewById(R.id.cb_like1);
        cbLike2 = (CheckBox) findViewById(R.id.cb_like2);
        cbLike3 = (CheckBox) findViewById(R.id.cb_like3);
        btnCommit2 = (Button) findViewById(R.id.btn_commit2);

        cbLike1.setOnCheckedChangeListener(onCheckedChangeListener());
        cbLike2.setOnCheckedChangeListener(onCheckedChangeListener());
        cbLike3.setOnCheckedChangeListener(onCheckedChangeListener());

        btnCommit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String like = "";
                if (cbLike1.isChecked())
                    like += cbLike1.getText() + " ";

                if (cbLike2.isChecked())
                    like += cbLike2.getText() + " ";

                if (cbLike3.isChecked())
                    like += cbLike3.getText() + " ";

                ToastAlone.showShortToast("选中的课程:" + like);
            }
        });

    }

    @NonNull
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener() {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    String s = buttonView.getText().toString();
                    ToastAlone.showShortToast("选中:" + s);
                }
            }
        };
    }

    /**
     * 单选框
     */
    private void radioButtons() {
        radioGroup = (RadioGroup) findViewById(R.id.rg_button);
        rbMan = (RadioButton) findViewById(R.id.rb_man);
        rbWoman = (RadioButton) findViewById(R.id.rb_woman);
        btnCommit = (Button) findViewById(R.id.btn_commit);

        // 设置默认选中
        rbMan.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                String text = radioButton.getText().toString();
                ToastAlone.showShortToast(text);
            }
        });


        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton radiobutton = (RadioButton) radioGroup.getChildAt(i);
                    if (radiobutton.isChecked()) {
                        ToastAlone.showShortToast(radiobutton.getText().toString());
                        break;
                    }
                }
            }
        });
    }

    private void setListener() {

    }
}
