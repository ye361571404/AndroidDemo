package com.hua.common;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.hua.R;


/**
 * @author
 */
public class ToastAlone {

    /**
     * 唯一的toast
     */
    private static Toast mToast;
    private static ToastAlone instance;

    public static ToastAlone getInstance() {

        if (instance == null) {
            synchronized (ToastAlone.class) {
                instance = new ToastAlone();
            }
        }
        return instance;
    }

    /**
     * @param ctx
     * @param tips
     * @param lastTime
     *
     * @return
     */
    public static void showToast(Context ctx, String tips, int lastTime) {
        showShortToast(tips);
    }

    /**
     * 返回数据错误
     *
     * @param context
     */
    public static void returnDataError(Context context) {
        showShortToast(R.string.fw_return_data_error);
    }

    //    public static void show(Context context, String text) {
    //        if(null == mToast) {
    //            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
    //        }
    //        mToast.setText(text);
    //        mToast.show();
    //    }
    //
    //    public static void show(Context context, int textRid) {
    //        if(null == mToast) {
    //            mToast = Toast.makeText(context, textRid, Toast.LENGTH_SHORT);
    //        }
    //        mToast.setText(textRid);
    //        mToast.show();
    //    }

    /**
     * 数据加载完成
     *
     * @param ctx
     */
    public static void dataLoadingDone(Context ctx) {
        showShortToast(R.string.fw_data_loading_done);
    }

    public static void showShortToast(String message) {

        if (!TextUtils.isEmpty(message)) {

            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.show();
        }
    }

    public static void showShortToast(int resId) {
        mToast.setText(resId);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void showLongToast(String message) {

        if (!TextUtils.isEmpty(message)) {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.show();
        }
    }

    public static void showLongToast(int resId) {

        mToast.setText(resId);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }

    //程序启动就完成初始化，引用全局的context
    public void init(Context context) {
        if (mToast == null) {
            synchronized (ToastAlone.class) {
                if (mToast == null) {
                    mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
                    //                    mToast.setGravity(Gravity.CENTER, 0, 0);
                }
            }
        }
    }
}