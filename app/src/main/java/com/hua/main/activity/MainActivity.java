package com.hua.main.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import com.demo.R;
import com.hua.common.ConstantItemEnum;
import com.hua.main.adapter.FeaturesAdapter;

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
        List<ConstantItemEnum> itemEnumList = Arrays.asList(ConstantItemEnum.values());
        mRecyclerview.setAdapter(new FeaturesAdapter(this,itemEnumList));
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.tv_item:
                ConstantItemEnum itemEnum = (ConstantItemEnum) v.getTag();
                startActivity(new Intent(this, itemEnum.getClazz()));

                break;
        }
    }
}
