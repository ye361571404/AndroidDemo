package hua.demo.feature.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hua.demo.R;
import hua.demo.feature.recyclerview.bean.GroupBean;

/**
 * Created by Administrator on 2017/4/2.
 */
public class RecyclerExpandableAdapter extends RecyclerView.Adapter<RecyclerExpandableAdapter.ViewHolder> implements View.OnClickListener {


    private Context mContext;
    private ArrayList<String> papers;
    private ArrayList<GroupBean> arrayList;

    public RecyclerExpandableAdapter(Context context, ArrayList<GroupBean> arrayList) {
        this.mContext = context;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.arrayList = arrayList;
        papers = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            papers.add("试卷"+i);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_recyclerview_expandable, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        GroupBean group = arrayList.get(position);
        holder.tvGroupName.setText(group.getGroupName());

        ExpandableAdapter adapter = (ExpandableAdapter) holder.rvContent.getAdapter();
        if (adapter == null) {
            adapter = new ExpandableAdapter(papers);
            holder.rvContent.setAdapter(adapter);
            holder.rvContent.setLayoutManager(new GridLayoutManager(mContext,3));
        }else{
            adapter.setShowMore(group.isShowMore());
        }

        holder.tvMore.setTag(holder.rvContent);
        holder.tvMore.setTag(R.id.tv_more,group);
        holder.tvMore.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    @Override
    public void onClick(View v) {
        GroupBean groupBean = (GroupBean) v.getTag(R.id.tv_more);
        RecyclerView recyclerVeiw = (RecyclerView) v.getTag();
        ExpandableAdapter adapter = (ExpandableAdapter) recyclerVeiw.getAdapter();
        boolean isShowMore = !adapter.isShowMore();
        adapter.setShowMore(isShowMore);
        groupBean.setShowMore(isShowMore);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvGroupName;
        TextView tvDes;
        TextView tvMore;
        RecyclerView rvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            tvGroupName = (TextView) itemView.findViewById(R.id.tv_group_name);
            tvDes = (TextView) itemView.findViewById(R.id.tv_des);
            tvMore = (TextView) itemView.findViewById(R.id.tv_more);
            rvContent = (RecyclerView) itemView.findViewById(R.id.rv_content);
        }

    }

}
