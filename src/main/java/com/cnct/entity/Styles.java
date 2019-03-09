package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/10/19.
 */
public class Styles implements Serializable {

    private Integer sid;

    private String sname;

    public Styles() {
    }

    public Styles(Integer sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Styles{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }
}

