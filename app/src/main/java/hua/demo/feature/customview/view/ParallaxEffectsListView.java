package hua.demo.feature.customview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ListView;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Administrator on 2017/3/15.
 *
 * 视差特效ListView
 */

public class ParallaxEffectsListView extends ListView {

    private final String TAG = getClass().getSimpleName();
    private int originHeight;
    private ImageView ivHeader;
    /** ImageView里面的图片高度 **/
    private int intrinsicHeight;


    public ParallaxEffectsListView(Context context) {
        super(context);
    }

    public ParallaxEffectsListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParallaxEffectsListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void parallaxEffects(ImageView ivHeader) {
        this.ivHeader = ivHeader;
        intrinsicHeight = ivHeader.getDrawable().getIntrinsicHeight();
        originHeight = ivHeader.getHeight();
        int measuredHeight = ivHeader.getMeasuredHeight();

        Log.e(TAG, "parallaxEffects: originHeight = " + originHeight);
        Log.e(TAG, "parallaxEffects: measuredHeight = " + measuredHeight);
    }


    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

        if(isTouchEvent && deltaY < 0){
            // 手指向下滑动
            int newHeight = (int) (ivHeader.getHeight() + Math.abs(deltaY) / 3.0f);
            if(newHeight < intrinsicHeight){
                // 避免超过图片的高度
                ivHeader.getLayoutParams().height = newHeight;
                ivHeader.requestLayout();
            }
        }
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                final int startValue = ivHeader.getHeight();
                ValueAnimator valueAnimator = ValueAnimator.ofInt(1);
                // 使用 nineoldandroids-2.4.0.jar 可以向下兼容
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float percent = animation.getAnimatedFraction();
                        Integer evaluate = evaluate(percent, startValue, originHeight);
                        ivHeader.getLayoutParams().height = evaluate;
                        ivHeader.requestLayout();
                    }
                });
                valueAnimator.setInterpolator(new OvershootInterpolator(2));
                valueAnimator.setDuration(500);
                valueAnimator.start();
                break;
        }
        return super.onTouchEvent(ev);
    }

    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int)(startInt + fraction * (endValue - startInt));
    }
}
