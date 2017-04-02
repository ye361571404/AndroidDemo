package hua.demo.feature.recyclerview.bean;

/**
 * Created by Administrator on 2017/4/2.
 */

public class GroupBean {

    /** 组名 **/
    private String groupName;
    /** 是否展开更多  true:是  false:否 **/
    private boolean isShowMore;

    public GroupBean(boolean b, String s) {
        this.groupName = s;
        this.isShowMore = b;
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
}
