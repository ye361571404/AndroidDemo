package com.hua.utils;

import android.os.Build;
import android.os.Environment;

import org.xutils.common.util.LogUtil;

import java.io.File;

import com.hua.common.Constants;
import com.hua.common.HuaApplication;

/**
 * Created by Administrator on 2017/4/9.
 */

public class StorageUtil {


    /**
     * 获取缓存目录
     * @param isCustomCache 是否获取内存卡中自定义的缓存目录
     * @return
     */
    public static File getCacheDir(boolean isCustomCache){
        File file = null;
        if (getExternalStorageState()) {
            // 有内存卡,获取内存卡缓存目录
            if(isCustomCache){
                // 获取内存卡中自定义的缓存目录
                file = Environment.getExternalStorageDirectory();
            }else{
                // 获取android内存卡中默认指定的缓存目录
                file = HuaApplication.getContext().getExternalCacheDir();
            }
        }else{
            // 无内存卡,获取内置存储缓存目录
            file = HuaApplication.getContext().getCacheDir();
        }
        return file;
    }


    /**
     * 获取外置存储状态
     * @return  true:已加载外置存储    false:未加载外置存储
     */
    public static boolean getExternalStorageState(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取 Constants.APP_CACHE_DIR 所在绝对路径
     * @return
     */
    public static File getAppCustomCacheRootDirectory(){
        String AppCustomCacheRootDirectory = getCacheDir(true).getAbsolutePath() + File.separator + Constants.APP_CACHE_DIR;
        return new File(AppCustomCacheRootDirectory);
    }


    /**
     * 获取fileName在 Constants.APP_CACHE_DIR 目录下的路径
     * @param fileName  文件名
     * @return
     */
    public static File getAppCustomCacheDirectory(String fileName){
        String AppExternalStorageDirectory = getCacheDir(true).getAbsolutePath() + File.separator + fileName;
        return new File(AppExternalStorageDirectory);
    }


    /**
     * 获取外置存储下制定文件或文件夹路径
     * @return
     */
    public static String getExternalStorageDirectory(String fileName){
        return Environment.getExternalStorageDirectory().getPath() + File.separator + fileName; //  + Constants.appCacheDir;
    }


    private void printEnvironment() {

        File dataDirectory = Environment.getDataDirectory();
        LogUtil.e("initData: dataDirectory = " + dataDirectory);                    // -> dataDirectory = /data

        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        LogUtil.e("initData: downloadCacheDirectory = " + downloadCacheDirectory);  // -> downloadCacheDirectory = /cache

        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        LogUtil.e("initData: externalStorageDirectory = " + externalStorageDirectory);  // -> externalStorageDirectory = /storage/emulated/0

        String externalStorageState = Environment.getExternalStorageState();
        LogUtil.e("initData: externalStorageState = " + externalStorageState);          // -> externalStorageState = mounted

        File rootDirectory = Environment.getRootDirectory();
        LogUtil.e("initData: rootDirectory = " + rootDirectory);                        // -> rootDirectory = /system

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String storageState = Environment.getExternalStorageState(new File("360"));
            LogUtil.e("initData: storageState = " + storageState);                      // -> initData: storageState = unknown
        }
    }

    private void printPath() {

        // 内部缓存路径
        File cacheDir = HuaApplication.getContext().getCacheDir();
        LogUtil.e("initData: cacheDir = " + cacheDir);                  // -> cacheDir = /data/data/com.demo/cache

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            File dataDir = HuaApplication.getContext().getDataDir();
            LogUtil.e("initData: dataDir = " + dataDir);
        }

        // 外部内存卡缓存路径
        File externalCacheDir = HuaApplication.getContext().getExternalCacheDir();
        LogUtil.e("initData: externalCacheDir = " + externalCacheDir);  // -> externalCacheDir = /storage/emulated/0/Android/data/com.demo/cache

        // 外部内存卡缓存路径下的所有文件夹
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File[] externalCacheDirs = HuaApplication.getContext().getExternalCacheDirs();
            for (File dir : externalCacheDirs) {
                LogUtil.e("initData: dir = " + dir);                    // -> dir = /storage/emulated/0/Android/data/com.demo/cache
            }
        }

        // 外部多媒体文件缓存路径
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            File[] externalMediaDirs = HuaApplication.getContext().getExternalMediaDirs();
            for (File externalMediaDir : externalMediaDirs) {
                LogUtil.e("initData: externalMediaDir = " + externalMediaDir);  // -> externalMediaDir = /storage/emulated/0/Android/media/com.demo
            }
        }

        File externalFilesDir = HuaApplication.getContext().getExternalFilesDir(Constants.APP_CACHE_DIR_CRASH);
        LogUtil.e("initData: externalFilesDir = " + externalFilesDir);              // ->  externalFilesDir = /storage/emulated/0/Android/data/com.demo/files/AndroidDemo/crash

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File[] externalFilesDirs = HuaApplication.getContext().getExternalFilesDirs(Constants.APP_CACHE_DIR);
            for (File filesDir : externalFilesDirs) {
                LogUtil.e("initData: filesDir = " + filesDir);                      // -> filesDir = /storage/emulated/0/Android/data/com.demo/files/AndroidDemo
            }
        }

        File filesDir = HuaApplication.getContext().getFilesDir();
        LogUtil.e("initData: filesDir = " + filesDir);                  // -> filesDir = /data/data/com.demo/files

        File obbDir = HuaApplication.getContext().getObbDir();
        LogUtil.e("initData: obbDir = " + obbDir);                      // -> obbDir = /storage/emulated/0/Android/obb/com.demo

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File[] obbDirs = HuaApplication.getContext().getObbDirs();
            for (File dir : obbDirs) {
                LogUtil.e("initData: dir = " + dir);                    // -> dir = /storage/emulated/0/Android/obb/com.demo
            }
        }

        String packageCodePath = HuaApplication.getContext().getPackageCodePath();
        LogUtil.e("initData: packageCodePath = " + packageCodePath);    // -> packageCodePath = /data/app/com.demo-1/base.apk

        String packageName = HuaApplication.getContext().getPackageName();
        LogUtil.e("initData: packageName = " + packageName);            // -> packageName = com.demo

        String packageResourcePath = HuaApplication.getContext().getPackageResourcePath();
        LogUtil.e("initData: packageResourcePath = " + packageResourcePath);    // -> packageResourcePath = /data/app/com.demo-1/base.apk
    }


}
