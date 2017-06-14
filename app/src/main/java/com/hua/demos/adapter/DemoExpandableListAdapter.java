package com.hua.demos.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hua.R;


public class DemoExpandableListAdapter implements android.widget.ExpandableListAdapter {

    private Context mContext;

    private String[] armTypes = new String[]{
            "WORD", "EXCEL", "EMAIL", "PPT"
    };
    private String[][] arms = new String[][]{
            {"文档编辑", "文档排版", "文档处理", "文档打印"},
            {"表格编辑", "表格排版", "表格处理", "表格打印"},
            {"收发邮件", "管理邮箱", "登录登出", "注册绑定"},
            {"演示编辑", "演示排版", "演示处理", "演示打印"},
    };


    public DemoExpandableListAdapter(Context context) {
        this.mContext = context;
    }


    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return armTypes.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return arms[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return armTypes[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arms[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_release_group, null);
            groupHolder = new GroupHolder();
            groupHolder.tvGroupName = (TextView) convertView.findViewById(R.id.tv_group_name);
            groupHolder.ivArrow = (ImageView) convertView.findViewById(R.id.iv_arrow);
            convertView.setTag(groupHolder);

        }else{
            groupHolder = (GroupHolder) convertView.getTag();
        }

        groupHolder.tvGroupName.setText(getGroup(groupPosition).toString());
        groupHolder.ivArrow.setSelected(isExpanded);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_release_child, null);
            childHolder = new ChildHolder();
            childHolder.tvChildName = (TextView) convertView.findViewById(R.id.tv_child_name);
            convertView.setTag(childHolder);
        }else{
            childHolder = (ChildHolder) convertView.getTag();
        }

        childHolder.tvChildName.setText(getChild(groupPosition, childPosition).toString());
        return convertView;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void rotateArrow(ImageView mArrowImageView) {
        long duration = 300;
        int degree = 0;
        if (mArrowImageView.getTag() == null || mArrowImageView.getTag().equals(true)) {
            mArrowImageView.setTag(false);
            degree = -180;
        } else {
            degree = 0;
            mArrowImageView.setTag(true);
        }
        mArrowImageView.animate().setDuration(duration).rotation(degree);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }



    class GroupHolder{
        TextView tvGroupName;
        ImageView ivArrow;

    }

    class ChildHolder{
        TextView tvChildName;
    }





}