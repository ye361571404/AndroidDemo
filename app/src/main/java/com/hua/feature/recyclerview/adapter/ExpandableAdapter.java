package com.hua.feature.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.hua.R;
import com.hua.common.HuaApplication;

/**
 * Created by Administrator on 2017/4/2.
 */
public class ExpandableAdapter extends RecyclerView.Adapter<ExpandableAdapter.ViewHolder> implements View.OnClickListener {


    private List<String> elements;
    /** 是否展开更多 **/
    private boolean isShowMore;

    public ExpandableAdapter(List<String> elements) {
        if (elements == null) {
            elements = new ArrayList<>();
        }
        this.elements = elements;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_expandable, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = elements.get(position);
        holder.tvPaperName.setText(s);
        holder.rlPaper.setOnClickListener(this);
    }


    @Override
    public int getItemCount() {
        if (isShowMore) {
            return elements.size();
        }else{
            if (elements.size() < 3) {
                return elements.size();
            }else{
                return 3;
            }
        }
    }

    public boolean isShowMore() {
        return isShowMore;
    }

    public void setShowMore(boolean showMore) {
        isShowMore = showMore;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(HuaApplication.getContext(), "打开试卷...", Toast.LENGTH_SHORT).show();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout rlPaper;
        TextView tvPaperName;

        public ViewHolder(View itemView) {
            super(itemView);
            rlPaper = (RelativeLayout) itemView.findViewById(R.id.rl_paper);
            tvPaperName = (TextView) itemView.findViewById(R.id.tv_paper_name);
        }

    }

}
