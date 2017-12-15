package com.hua.demos.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hua.R;
import com.hua.demos.bean.ExerciseBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 */

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    private final View.OnClickListener onClickListener;
    private List<ExerciseBean> exerciseList;

    public ExerciseAdapter(View.OnClickListener onClickListener, List<ExerciseBean> exerciseList) {
        this.onClickListener = onClickListener;
        this.exerciseList = exerciseList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_exercise, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ExerciseBean bean = exerciseList.get(position);
        holder.tvItem.setTag(bean);
        holder.tvItem.setText(bean.getName());
        holder.tvItem.setOnClickListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvItem;

        public ViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }

}
