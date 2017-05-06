package com.hua.feature.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/3/4.
 */

public class CustomViewOne extends View implements View.OnClickListener {

    private int count;
    private Paint paint;

    public CustomViewOne(Context context) {
        super(context);
        init();
    }

    public CustomViewOne(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomViewOne(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnClickListener(this);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        paint = new Paint();
        // 设置抗锯齿
        paint.setAntiAlias(true);
        paint.setTextSize(50);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 1.计算view的中心点
        int centerX = getMeasuredWidth() / 2;
        int centerY = getMeasuredHeight() / 2;

        // 2.画圆
        paint.setColor(Color.RED);
        // FILL填充效果,不包括描边   STROKE:只描边  FILL_AND_STROKE:填充并描边
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(centerX, centerY,100,paint);

        // 3.画文字
        String text = count + "";
        // 用于记录文字所需的宽高
        Rect bounds = new Rect();
        // 获取文字所需的宽高
        paint.getTextBounds(text,0,text.length(),bounds);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        // 计算文字的起始位置
        int textShowX = centerX - bounds.width() / 2;
        int textShowY = centerY + bounds.height() / 2;
        canvas.drawText(text, textShowX, textShowY,paint);


    }

    @Override
    public void onClick(View v) {
        count++;
        // 重新绘制
        // 只能在主线程中使用
        // invalidate();
        // 能在子线程中使用
        postInvalidate();
    }
}
