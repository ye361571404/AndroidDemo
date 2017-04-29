package hua.demo.common;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by Administrator on 2017/3/6.
 */

public class HuaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Context
        context = getApplicationContext();
        //mainThreadId
        mainThreadId = android.os.Process.myTid();
        //Thread-->object
        mainThread = Thread.currentThread();
        //Handler
        handler = new Handler();

        x.Ext.init(this);
        // 是否输出debug日志, 开启debug会影响性能.
        x.Ext.setDebug(BuildConfig.DEBUG);

        // 添加 奔溃日志 本地记录
        // CrashHandler.getInstance().init(this);
        // 初始化toast
        ToastAlone.getInstance().init(this);
    }

    private static Context context;
    private static int mainThreadId;
    private static Thread mainThread;
    private static Handler handler;

    public static Context getContext() {
        return context;
    }
    public static int getMainThreadId() {
        return mainThreadId;
    }
    public static Thread getMainThread() {
        return mainThread;
    }
    public static Handler getHandler() {
        return handler;
    }

}
