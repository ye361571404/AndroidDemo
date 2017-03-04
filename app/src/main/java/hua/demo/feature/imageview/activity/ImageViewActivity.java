package hua.demo.feature.imageview.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import hua.demo.R;
import hua.demo.main.activity.BaseActivity;

/**
 * Created by Administrator on 2017/3/1.
 */

public class ImageViewActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mIvArrow;

    @Override
    protected int getLayoutRes() {
        return R.layout.imageview_activity;
    }

    @Override
    protected void assignViews() {
        mIvArrow = (ImageView) findViewById(R.id.iv_arrow);
    }

    @Override
    protected void setListener() {
        mIvArrow.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_arrow:
                rotateArrow((ImageView) v);
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void rotateArrow(ImageView mArrowImageView) {
        long duration = 300;
        int degree = 0;
        if (mArrowImageView.getTag() == null || mArrowImageView.getTag().equals(true)) {
            mArrowImageView.setTag(false);
            degree = -180;
        } else {
            degree = 0;
            mArrowImageView.setTag(true);
        }
        mArrowImageView.animate().setDuration(duration).rotation(degree);
    }



}
