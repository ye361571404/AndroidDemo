package hua.demo.feature.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import hua.demo.R;

/**
 * Created by Administrator on 2017/4/2.
 */
public class ExpandableAdapter extends RecyclerView.Adapter<ExpandableAdapter.ViewHolder> {


    private ArrayList<String> papers;
    /** 是否展开更多 **/
    private boolean isShowMore;

    public ExpandableAdapter(ArrayList<String> papers) {
        if (papers == null) {
            papers = new ArrayList<>();
        }
        this.papers = papers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_expandable, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = papers.get(position);
        holder.tvPaperName.setText(s);

    }

    /*@Override
    public int getItemCount() {
        return papers.size();
    }*/

    @Override
    public int getItemCount() {
        if (isShowMore) {
            return papers.size();
        }else{
            if (papers.size() < 3) {
                return papers.size();
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
