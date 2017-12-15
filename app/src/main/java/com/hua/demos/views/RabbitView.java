package com.hua.demos.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hua.R;

/**
 * 随手指移动的兔子View
 * Created by Administrator on 2017/12/15.
 */

public class RabbitView extends View {

    public float bitmapX;
    public float bitmapY;

    public RabbitView(Context context) {
        super(context);
        bitmapX = 150;
        bitmapY = 150;
    }

    public RabbitView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RabbitView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rabbit);
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);

        if (bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}
