package hua.demo.feature.recyclerview.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import hua.demo.R;
import hua.demo.feature.recyclerview.adapter.RecyclerExpandableAdapter;
import hua.demo.feature.recyclerview.adapter.SpaceItemDecoration;
import hua.demo.feature.recyclerview.bean.GroupBean;
import hua.demo.main.activity.BaseActivity;

public class RecyclerExpandableActivity extends BaseActivity {


    @Bind(R.id.rv_content)
    RecyclerView rvContent;
    private ArrayList<GroupBean> arrayList;

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
        arrayList = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            arrayList.add(new GroupBean(false, "第"+i+"组"));
        }

        rvContent.setAdapter(new RecyclerExpandableAdapter(mContext,arrayList));
        rvContent.setLayoutManager(new LinearLayoutManager(mContext));

    }

}
