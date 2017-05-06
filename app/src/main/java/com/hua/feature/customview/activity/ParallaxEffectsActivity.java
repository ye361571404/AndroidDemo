package com.hua.feature.customview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.hua.R;
import com.hua.feature.customview.view.ParallaxEffectsListView;


/**
 * 视差效果
 */
public class ParallaxEffectsActivity extends AppCompatActivity {

    @Bind(R.id.lv_content)
    ParallaxEffectsListView mLvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallax_effects);
        ButterKnife.bind(this);

        View header = View.inflate(ParallaxEffectsActivity.this, R.layout.listview_header_image, null);
        final ImageView ivHeader = (ImageView) header.findViewById(R.id.iv_header);

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i+"");
        }

        mLvContent.addHeaderView(header);
        ivHeader.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mLvContent.parallaxEffects(ivHeader);
                ivHeader.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });


        mLvContent.setAdapter(new ArrayAdapter<String>(ParallaxEffectsActivity.this,android.R.layout.simple_list_item_1,arrayList));


        /*
            1.获取header高度
            2.header高度累加滑动超出高度
            3.松开恢复原来高度
         */

    }
}
