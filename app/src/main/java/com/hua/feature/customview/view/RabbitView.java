package com.hua.feature.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.hua.R;

/**
 * Created by Administrator on 2017/3/14.
 */

public class RabbitView extends View {

    private final String TAG = "RabbitView";

    public float bitmapX;
    public float bitmapY;

    public RabbitView(Context context) {
        super(context);
        init();
    }

    public RabbitView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public RabbitView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        // 处理该自定义控件写在布局里面时,onDraw()方法不执行
        setWillNotDraw(false);

        bitmapX = 50; // 设置兔子的默认显示位置的X坐标
        bitmapY = 50; // 设置兔子的默认显示位置的Y坐标
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap rabbitBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rabbit);
        Paint paint = new Paint(); // 创建并实例化Paint的对象
        canvas.drawBitmap(rabbitBitmap,bitmapX,bitmapY,paint);
        if (rabbitBitmap.isRecycled()) {
            rabbitBitmap.recycle();
        }
    }

}
