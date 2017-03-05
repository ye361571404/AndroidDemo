package hua.demo.common;

import hua.demo.feature.customview.activity.CustomViewActivity;
import hua.demo.feature.imageview.activity.ImageViewActivity;
import hua.demo.feature.recyclerview.activity.RecyclerViewActivity;

/**
 * Created by Administrator on 2017/3/2.
 */

public enum ConstantItemEnum {


    RECYCLER_VIEW("01 RecyclerView 实现下拉刷新上拉加载",RecyclerViewActivity.class),
    IMAGE_VIEW("02 ImageView",ImageViewActivity.class),
    CUSTOM_VIEW("03 自定义view",CustomViewActivity.class);

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