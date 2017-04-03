package hua.demo.feature.recyclerview.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import hua.demo.R;

/**
 * Created by Administrator on 2017/4/3.
 */
public class DesHolder extends RecyclerView.ViewHolder{


    public RelativeLayout rlDes;
    public TextView tvDesName;

    public DesHolder(View itemView) {
        super(itemView);
        rlDes = (RelativeLayout) itemView.findViewById(R.id.rl_des);
        tvDesName = (TextView) itemView.findViewById(R.id.tv_des_name);
    }

}
