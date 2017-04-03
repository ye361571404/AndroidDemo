package hua.demo.feature.recyclerview.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import hua.demo.feature.recyclerview.adapter.holder.DesHolder;
import hua.demo.feature.recyclerview.adapter.holder.HeaderHolder;

/**
 * Created by Administrator on 2017/4/3.
 */
public class SectionedSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

    private final String TAG = getClass().getSimpleName();
    private SectionedRecyclerViewAdapter<?, ?, ?> adapter = null;
    private GridLayoutManager gridLayoutManager = null;

    public SectionedSpanSizeLookup(SectionedRecyclerViewAdapter<?, ?, ?> adapter, GridLayoutManager gridLayoutManager) {
        this.adapter = adapter;
        this.gridLayoutManager = gridLayoutManager;
    }

    @Override
    public int getSpanSize(int position) {
        if(adapter.isSectionHeaderPosition(position) || adapter.isSectionFooterPosition(position)){
            Log.e(TAG, "getSpanSize: = " + gridLayoutManager.getSpanCount());
            return gridLayoutManager.getSpanCount();
        }else{
            Log.e(TAG, "getSpanSize: = 1");
            return 1;
        }
    }
}
