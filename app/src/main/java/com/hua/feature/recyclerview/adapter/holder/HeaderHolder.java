package com.hua.feature.recyclerview.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.demo.R;

/**
 * Created by Administrator on 2017/4/3.
 */
public class HeaderHolder extends RecyclerView.ViewHolder{


    public TextView tvGroupName;
    public TextView tvMore;
    public TextView tvDes;

    public HeaderHolder(View itemView) {
        super(itemView);
        tvGroupName = (TextView) itemView.findViewById(R.id.tv_group_name);
        tvMore = (TextView) itemView.findViewById(R.id.tv_more);
        tvDes = (TextView) itemView.findViewById(R.id.tv_des);
    }

}
