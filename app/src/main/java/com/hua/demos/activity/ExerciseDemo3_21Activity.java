package com.hua.demos.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.hua.R;
import com.hua.common.ToastAlone;

import java.util.Calendar;

/**
 * Created by Administrator on 2018/1/3.
 */

public class ExerciseDemo3_21Activity extends AppCompatActivity{


    private DatePicker datePicker;
    private TimePicker timePicker;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_demo3_21);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);


        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);


        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                ExerciseDemo3_21Activity.this.year = year;
                ExerciseDemo3_21Activity.this.month = monthOfYear;
                ExerciseDemo3_21Activity.this.day = dayOfMonth;
                show(year,month,day,hour,minute);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                ExerciseDemo3_21Activity.this.hour = hourOfDay;
                ExerciseDemo3_21Activity.this.minute = minute;
                show(year,month,day,hourOfDay,minute);
            }
        });


    }

    private void show(int year, int month, int day, int hour, int minute) {
        StringBuffer date = new StringBuffer();
        date.append(year + "年")
                .append((month + 1) + "月")
                .append(day + "日")
                .append(hour + "时")
                .append(minute + "分");

        ToastAlone.showShortToast(date.toString());
    }
}
