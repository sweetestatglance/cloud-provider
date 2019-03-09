package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/10/16.
 * 类型
 */
public class Types implements Serializable {

    private Integer tid; //类型id

    private String tname; //类型名称

    private String width; //图片的长高

    private String height;

    public Types() {
    }

    public Types(Integer tid, String tname, String width, String height) {
        this.tid = tid;
        this.tname = tname;
        this.width = width;
        this.height = height;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Types{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
