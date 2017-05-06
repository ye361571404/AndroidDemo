package com.hua.feature.recyclerview.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import com.demo.R;
import com.hua.feature.recyclerview.adapter.RecyclerExpandableAdapter;
import com.hua.feature.recyclerview.bean.GroupBean;
import com.hua.main.activity.BaseActivity;

public class RecyclerExpandableActivity extends BaseActivity {


    @Bind(R.id.rv_content)
    RecyclerView rvContent;
    private ArrayList<GroupBean> groupList;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_recycler_expandable;
    }

    @Override
    protected void assignViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        initList();

    }

    private void initList() {
        groupList = new ArrayList<>();
        GroupBean groupBean = null;
        List<String> elements = null;
        for (int i = 1; i < 21; i++) {
            elements = new ArrayList<>();
            for (int j = 1; j < 5; j++) {
                elements.add("试卷"+j);
            }
            groupBean = new GroupBean(false, "第" + i + "组",elements);
            groupList.add(groupBean);
        }

        rvContent.setAdapter(new RecyclerExpandableAdapter(mContext, groupList));
        rvContent.setLayoutManager(new LinearLayoutManager(mContext));
    }

}
