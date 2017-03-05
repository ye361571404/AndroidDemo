package hua.demo.common;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/3/6.
 */

public class HuaApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = getApplicationContext();
    }

}
