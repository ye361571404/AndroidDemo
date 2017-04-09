package hua.demo.common;

import hua.demo.feature.assets.activity.AssetsDemoActivity;
import hua.demo.feature.launchmode.activity.LaunchModeActivity;
import hua.demo.feature.customview.activity.CustomViewActivity;
import hua.demo.feature.imageview.activity.ImageViewActivity;
import hua.demo.feature.player.activity.MusicPlayerActivity;
import hua.demo.feature.recyclerview.activity.RecyclerExpandableActivity;
import hua.demo.feature.recyclerview.activity.RecyclerViewActivity;
import hua.demo.feature.recyclerview.activity.SectionRecyclerViewActivity;
import hua.demo.feature.rxjava.RxJavaDemoActivity;
import hua.demo.feature.showgif.activity.ShowGifActivity;

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
    ASSEST("08 操作Assets目录文件",AssetsDemoActivity.class);

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
