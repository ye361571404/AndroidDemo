package hua.demo.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hua.demo.R;

/**
 * Created by Administrator on 2017/2/24.
 */
public class FeaturesAdapter extends RecyclerView.Adapter<FeaturesAdapter.ViewHolder> {


    private View.OnClickListener onClickListener;
    private List<String> items;

    public FeaturesAdapter(View.OnClickListener onClickListener, List<String> items) {
        this.onClickListener = onClickListener;
        if (items == null) {
            items = new ArrayList<>();
        }
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_features, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = items.get(position);
        holder.mItem.setText(s);
        holder.mItem.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView mItem;

        public ViewHolder(View itemView) {
            super(itemView);
            mItem = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }


}
