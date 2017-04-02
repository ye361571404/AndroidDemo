package hua.demo.feature.recyclerview.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 设置RecyclerView间距
 * Created by Administrator on 2017/4/2.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {


    private Rect outRect;


    public SpaceItemDecoration(Rect outRect) {
        this.outRect = outRect;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if(parent.getChildPosition(view) != 0)
            outRect = this.outRect;
    }

}
