package com.hua.demos.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.hua.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/3.
 */

public class ExerciseDemo3_24Activity extends AppCompatActivity {

    private ListView lvContent;
    private int[] imageId = new int[]{
            R.drawable.img01,
            R.drawable.img02,
            R.drawable.img03,
            R.drawable.img04,
            R.drawable.img05,
            R.drawable.img06,
            R.drawable.img07,
            R.drawable.img08
    };
    private String[] titles = new String[]{"保密设置","安全","系统设置","上网","我的文档","GPS导航","我的音乐","E-mail"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_demo3_24);

        lvContent = (ListView) findViewById(R.id.lv_content);

        List<Map<String, Object>> itemValues = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < titles.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageId", imageId[i]);
            item.put("title", titles[i]);
            itemValues.add(item);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, itemValues, R.layout.item_settings_demo, new String[]{"imageId", "title"}, new int[]{R.id.image, R.id.textView});

        lvContent.setAdapter(simpleAdapter);


    }
}
