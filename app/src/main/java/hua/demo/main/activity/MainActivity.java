package hua.demo.main.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hua.demo.R;
import hua.demo.feature.recyclerview.activity.RecyclerViewActivity;
import hua.demo.main.adapter.FeaturesAdapter;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private RecyclerView mRecyclerview;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }


    @Override
    public void assignViews() {
        mRecyclerview = (RecyclerView)findViewById(R.id.recyclerview);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        List<String> items = new ArrayList<>();
        String[] features = getResources().getStringArray(R.array.features);
        items = Arrays.asList(features);
        mRecyclerview.setAdapter(new FeaturesAdapter(this,items));
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.tv_item:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
        }
    }
}
