package com.hua.feature.recyclerview.adapter;

import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.demo.R;
import com.hua.feature.recyclerview.adapter.holder.DesHolder;
import com.hua.feature.recyclerview.adapter.holder.FooterHolder;
import com.hua.feature.recyclerview.adapter.holder.HeaderHolder;
import com.hua.feature.recyclerview.bean.GroupBean;

/**
 * Created by Administrator on 2017/4/3.
 */
public class GroupRecyclerViewAdapter extends SectionedRecyclerViewAdapter<HeaderHolder,DesHolder,FooterHolder>{


    private List<GroupBean> groupList;

    /**
     * 用于保存每个Section(段)是否展开的状态
     * true:已展开    false:未展开
     */
    private SparseBooleanArray mBooleanMap;

    public GroupRecyclerViewAdapter(List<GroupBean> groupList) {
        if (groupList == null) {
            groupList = new ArrayList<>();
        }
        this.groupList = groupList;
        mBooleanMap = new SparseBooleanArray();
    }

    /**
     * 一共有多少段
     * @return
     */
    @Override
    protected int getSectionCount() {
        return groupList.size();
    }

    /**
     * 返回该段除了header要展示的item的数量
     * @param section   当前段的下标
     * @return
     */
    @Override
    protected int getItemCountForSection(int section) {
        int count = groupList.get(section).getElements().size();
        if(count > 3 && !mBooleanMap.get(section)){
            return 3;
        }
        return count;
    }

    /**
     * 是否footer布局
     * @param section
     * @return  true:有  false:无
     */
    @Override
    protected boolean hasFooterInSection(int section) {
        return true;
    }

    /**
     * 创建header
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    protected HeaderHolder onCreateSectionHeaderViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_group_header, null);
        return new HeaderHolder(inflate);
    }

    /**
     * 创建footer
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    protected FooterHolder onCreateSectionFooterViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_group_footer, null);
        return new FooterHolder(inflate);
    }

    /**
     * 创建item
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    protected DesHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_group_des, null);
        return new DesHolder(inflate);
    }

    /**
     * 设置header展示数据和响应事件
     * @param holder
     * @param section
     */
    @Override
    protected void onBindSectionHeaderViewHolder(final HeaderHolder holder, final int section) {
        holder.tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isOpen = !mBooleanMap.get(section);
                String text = isOpen ? "关闭" : "展开";
                mBooleanMap.put(section,isOpen);
                holder.tvMore.setText(text);
                notifyDataSetChanged();
            }
        });

        // 设置组名
        holder.tvGroupName.setText(groupList.get(section).getGroupName());
        // 设置开关状态
        holder.tvMore.setText(mBooleanMap.get(section)?"关闭":"展开");
    }

    /**
     * 设置footer展示数据和响应事件
     * @param holder
     * @param section
     */
    @Override
    protected void onBindSectionFooterViewHolder(FooterHolder holder, int section) {

    }

    /**
     * 设置item展示数据和响应事件
     * @param holder
     * @param section
     * @param position
     */
    @Override
    protected void onBindItemViewHolder(DesHolder holder, int section, int position) {
        holder.tvDesName.setText(groupList.get(section).getElements().get(position));
    }

}
