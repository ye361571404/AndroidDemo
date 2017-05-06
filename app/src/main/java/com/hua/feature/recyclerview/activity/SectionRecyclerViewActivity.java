package com.hua.feature.recyclerview.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import com.hua.R;
import com.hua.feature.recyclerview.adapter.GroupRecyclerViewAdapter;
import com.hua.feature.recyclerview.adapter.SectionedSpanSizeLookup;
import com.hua.feature.recyclerview.bean.GroupBean;
import com.hua.main.activity.BaseActivity;

/**
 * 该demo实现源自博客:http://blog.csdn.net/wzlyd1/article/details/52292548
 */
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
        // 初始化列表数据
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


        // 将列表数据展示到控件上
        final GroupRecyclerViewAdapter adapter = new GroupRecyclerViewAdapter(groupList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
        // 设置header/footer/item分别占据的空间
        gridLayoutManager.setSpanSizeLookup(new SectionedSpanSizeLookup(adapter,gridLayoutManager));
        rvContent.setLayoutManager(gridLayoutManager);

        rvContent.setAdapter(adapter);
    }



}
