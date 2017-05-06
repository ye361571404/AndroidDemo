package com.hua.feature.recyclerview.adapter;

import android.support.v7.widget.GridLayoutManager;

/**
 * Created by Administrator on 2017/4/3.
 * 这个类是用来自定义每个item需要占据的空间
 */
public class SectionedSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

    private SectionedRecyclerViewAdapter<?, ?, ?> adapter = null;
    private GridLayoutManager gridLayoutManager = null;

    public SectionedSpanSizeLookup(SectionedRecyclerViewAdapter<?, ?, ?> adapter, GridLayoutManager gridLayoutManager) {
        this.adapter = adapter;
        this.gridLayoutManager = gridLayoutManager;
    }

    /**
     * 根据position返回需要占用的空间
     * @param position
     * @return
     */
    @Override
    public int getSpanSize(int position) {
        if(adapter.isSectionHeaderPosition(position) || adapter.isSectionFooterPosition(position)){
            // 返回header/footer需要占据的空间
            return gridLayoutManager.getSpanCount();
        }else{
            // 返回普通item需要占据的空间
            return 1;
        }
    }
}
