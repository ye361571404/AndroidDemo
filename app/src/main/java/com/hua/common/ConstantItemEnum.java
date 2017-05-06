package com.hua.common;

import com.hua.feature.assets.activity.AssetsDemoActivity;
import com.hua.feature.launchmode.activity.LaunchModeActivity;
import com.hua.feature.customview.activity.CustomViewActivity;
import com.hua.feature.imageview.activity.ImageViewActivity;
import com.hua.feature.player.activity.MusicPlayerActivity;
import com.hua.feature.proguard.activity.ProguardActivity;
import com.hua.feature.recyclerview.activity.RecyclerExpandableActivity;
import com.hua.feature.recyclerview.activity.RecyclerViewActivity;
import com.hua.feature.recyclerview.activity.SectionRecyclerViewActivity;
import com.hua.feature.rxjava.RxJavaDemoActivity;
import com.hua.feature.sharedpreferences.activity.SharedPreferencesActivity;
import com.hua.feature.showgif.activity.ShowGifActivity;

/**
 * Created by Administrator on 2017/3/2.
 */

public enum ConstantItemEnum {


    RECYCLER_VIEW("01 RecyclerView 实现下拉刷新上拉加载",RecyclerViewActivity.class),
    RECYCLER_EXPANDABLE_VIEW_DEMO01("01 RecyclerView 实现可以展开收缩的item-demo1",RecyclerExpandableActivity.class),
    RECYCLER_EXPANDABLE_VIEW_DEMO02("01 RecyclerView 实现可以展开收缩的item-demo2",SectionRecyclerViewActivity.class),
    IMAGE_VIEW("02 ImageView",ImageViewActivity.class),
    CUSTOM_VIEW("03 自定义view",CustomViewActivity.class),
    MUSIC_PLAYER("04 音乐播放器",MusicPlayerActivity.class),
    RXJAVA("05 RxJava",RxJavaDemoActivity.class),
    LAUNCH_MODE("06 Activity启动模式",LaunchModeActivity.class),
    SHOW_GIF("07 显示gif图片",ShowGifActivity.class),
    ASSEST("08 操作Assets目录文件",AssetsDemoActivity.class),
    SHARED_PREFERENCES("09 操作SharedPreferences文件",SharedPreferencesActivity.class),
    DEMO_PROGUAR_ACTIVITY("10 测试混淆",ProguardActivity.class);

    private int itemType;

    private String itemName;

    private Class clazz;

    ConstantItemEnum( String itemName, Class clazz) {
        this.itemName = itemName;
        this.clazz = clazz;
    }

    public int getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public Class getClazz() {
        return clazz;
    }
}
