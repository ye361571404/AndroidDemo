package com.hua.demos.views;

import android.widget.ExpandableListView;

import com.hua.R;
import com.hua.demos.adapter.DemoExpandableListAdapter;
import com.hua.main.activity.BaseActivity;

public class ExpandableListViewActivity extends BaseActivity {


    private ExpandableListView elvContent;
    private DemoExpandableListAdapter mAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_expandable_list_view;
    }

    @Override
    protected void assignViews() {
        elvContent = (ExpandableListView) findViewById(R.id.elv_content);
        // 去除默认箭头
        elvContent.setGroupIndicator(null);
        mAdapter = new DemoExpandableListAdapter(ExpandableListViewActivity.this);
        elvContent.setAdapter(mAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }
}
