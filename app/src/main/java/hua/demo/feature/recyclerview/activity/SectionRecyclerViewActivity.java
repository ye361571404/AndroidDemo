package hua.demo.feature.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import hua.demo.R;
import hua.demo.feature.recyclerview.adapter.GroupRecyclerViewAdapter;
import hua.demo.feature.recyclerview.adapter.RecyclerExpandableAdapter;
import hua.demo.feature.recyclerview.adapter.SectionedSpanSizeLookup;
import hua.demo.feature.recyclerview.bean.GroupBean;
import hua.demo.main.activity.BaseActivity;

public class SectionRecyclerViewActivity extends BaseActivity {

    @Bind(R.id.rv_content)
    RecyclerView rvContent;
    private ArrayList<GroupBean> groupList;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_section_recycler_view;
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
            int elementsCount = i%2==0?5:2;
            for (int j = 1; j < elementsCount; j++) {
                elements.add("试卷"+j);
            }
            groupBean = new GroupBean(false, "第" + i + "组",elements);
            groupList.add(groupBean);
        }


        final GroupRecyclerViewAdapter adapter = new GroupRecyclerViewAdapter(mContext, groupList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
        gridLayoutManager.setSpanSizeLookup(new SectionedSpanSizeLookup(adapter,gridLayoutManager));
        rvContent.setLayoutManager(gridLayoutManager);
        rvContent.setAdapter(adapter);
    }



}
