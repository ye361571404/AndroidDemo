package com.hua.demos.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.hua.R;
import com.hua.common.ToastAlone;

/**
 * Created by Administrator on 2018/1/2.
 */

public class ExerciseDemo3_18Activity extends AppCompatActivity{

    private String[] ctype = new String[]{"name01","name02","name03","name04"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_demo3_18);


        ListView lvContent = (ListView) findViewById(R.id.lv_content);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ctype);
        lvContent.setAdapter(adapter);

        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = parent.getItemAtPosition(position).toString();
                ToastAlone.showShortToast(value);

            }
        });

    }
}
