package hua.demo.feature.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hua.demo.R;
import hua.demo.feature.recyclerview.adapter.holder.DesHolder;
import hua.demo.feature.recyclerview.adapter.holder.FooterHolder;
import hua.demo.feature.recyclerview.adapter.holder.HeaderHolder;
import hua.demo.feature.recyclerview.bean.GroupBean;

/**
 * Created by Administrator on 2017/4/3.
 */
public class GroupRecyclerViewAdapter extends SectionedRecyclerViewAdapter<HeaderHolder,DesHolder,FooterHolder>{


    private List<GroupBean> groupList;
    private Context mContext;

    private SparseBooleanArray mBooleanMap;

    public GroupRecyclerViewAdapter(Context context, ArrayList<GroupBean> groupList) {
        this.mContext = context;
        if (groupList == null) {
            groupList = new ArrayList<>();
        }
        this.groupList = groupList;
        mBooleanMap = new SparseBooleanArray();
    }

    @Override
    protected int getSectionCount() {
        return groupList.size();
    }

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

    @Override
    protected HeaderHolder onCreateSectionHeaderViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_group_header, null);
        return new HeaderHolder(inflate);
    }

    @Override
    protected FooterHolder onCreateSectionFooterViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_group_footer, null);
        return new FooterHolder(inflate);
    }

    @Override
    protected DesHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_group_des, null);
        return new DesHolder(inflate);
    }

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

    @Override
    protected void onBindSectionFooterViewHolder(FooterHolder holder, int section) {

    }

    @Override
    protected void onBindItemViewHolder(DesHolder holder, int section, int position) {
        holder.tvDesName.setText(groupList.get(section).getElements().get(position));
    }


    public void setData(List<GroupBean> groupList) {
        this.groupList = groupList;
        notifyDataSetChanged();
    }
}
