package com.hua.feature.recyclerview.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 */

public class GroupBean {

    /** 组名 **/
    private String groupName;
    /** 是否展开更多  true:是  false:否 **/
    private boolean isShowMore;
    /** 组里面的元素 **/
    private List<String> elements;

    public GroupBean(boolean b, String s, List<String> elements) {
        this.groupName = s;
        this.isShowMore = b;
        this.elements = elements;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isShowMore() {
        return isShowMore;
    }

    public void setShowMore(boolean showMore) {
        isShowMore = showMore;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }
}
