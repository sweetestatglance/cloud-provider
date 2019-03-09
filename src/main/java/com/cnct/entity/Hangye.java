package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/10/19.
 */
public class Hangye implements Serializable {

    private Integer hid;

    private String hname;

    public Hangye() {
    }

    public Hangye(Integer hid, String hname) {
        this.hid = hid;
        this.hname = hname;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    @Override
    public String toString() {
        return "Hangye{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                '}';
    }
}
