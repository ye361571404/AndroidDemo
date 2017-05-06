package com.hua.feature.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/3/4.
 */

public class CustomProgress extends View {


    private int progress;
    private int max;
    private String text;
    private Paint mPaint;

    public CustomProgress(Context context) {
        super(context);
        init();
    }

    public CustomProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(30);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        // 1.计算中心点
        int centerx = getMeasuredWidth() / 2;
        int centerY = getMeasuredHeight() / 2;


        // 2.画圆
        mPaint.setStrokeWidth(1);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        // 为了让圆形被弧形完整覆盖,半径减4
        canvas.drawCircle(centerx, centerY, centerx - 4, mPaint);

        // 3.画弧形
        mPaint.setColor(Color.GREEN);
        int strokeWidth = 5;
        mPaint.setStrokeWidth(strokeWidth);
        // 为了让弧形完整显示,left,top,right,bottom往里缩进 strokeWidth
        RectF rectf = new RectF(0+strokeWidth,0+strokeWidth,getMeasuredWidth()-strokeWidth,getMeasuredHeight()-strokeWidth);
        canvas.drawArc(rectf,0,360*progress/max,false, mPaint);

        // 4.画文字
        mPaint.setStyle(Paint.Style.FILL);
        Rect bounds = new Rect();
        mPaint.getTextBounds(text,0,text.length(),bounds);
        // 计算文字显示起始位置
        int textShowX = centerx - bounds.width() / 2;
        int textShowY = centerY + bounds.height() / 2;
        canvas.drawText(text, textShowX, textShowY, mPaint);
    }


    public void setMax(int max){
        this.max = max;
    }

    public void setProgressAndText(int progress,String text){
        this.progress = progress;
        this.text = text;
        postInvalidate();
    }

}
