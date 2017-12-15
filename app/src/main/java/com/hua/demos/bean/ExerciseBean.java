package com.hua.demos.bean;


/**
 * Created by Administrator on 2017/12/15.
 */

public class ExerciseBean {

    private String name;
    private Class clazz;

    public ExerciseBean(String name, Class clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
