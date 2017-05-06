package com.hua.feature.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.demo.R;

/**
 * Created by Administrator on 2017/2/24.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public ArrayList<String> itemDatas = null;

    public RecyclerViewAdapter(ArrayList<String> datas) {
        this.itemDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // ViewHolder的item.xml如果使用LinearLayout有可能出现match_parent失效
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mItem.setText(itemDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return itemDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mItem;

        public ViewHolder(View view) {
            super(view);
            mItem = (TextView) view.findViewById(R.id.tv_item);
        }
    }

}