package com.hua.feature.showgif.activity;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import butterknife.Bind;
import com.demo.R;
import com.hua.main.activity.BaseActivity;

public class ShowGifActivity extends BaseActivity {

    @Bind(R.id.iv_show_gif)
    ImageView ivShowGif;


    private String gifUrl = "http://i.dimg.cc/73/2a/6d/aa/5f/53/88/fe/4f/ef/20/dd/ab/3a/1d/7a.jpg";
    private ImageOptions imageOptions;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_show_gif;
    }

    @Override
    protected void assignViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        imageOptions = new ImageOptions.Builder()
                .setSize(0, 0)
                .setRadius(DensityUtil.dip2px(5))
                // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setCrop(true) // 很多时候设置了合适的scaleType也不需要它.
                // 加载中或错误图片的ScaleType
                //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                .setFailureDrawableId(R.mipmap.ic_launcher)
                //设置支持gif
                .setIgnoreGif(false)
                .build();


        x.image().bind(ivShowGif, gifUrl, imageOptions, new Callback.CacheCallback<Drawable>() {
            @Override
            public boolean onCache(Drawable result) {
                Toast.makeText(mContext, "onCache", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSuccess(Drawable result) {
                Toast.makeText(mContext, "onSuccess", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(mContext, "onError", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(mContext, "onCancelled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinished() {
                Toast.makeText(mContext, "onFinished", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
