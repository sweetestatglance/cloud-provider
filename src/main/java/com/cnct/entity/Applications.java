package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/10/19.
 */
public class Applications implements Serializable {

    private Integer aid;

    private String aname;

    public Applications() {
    }

    public Applications(Integer aid, String aname) {
        this.aid = aid;
        this.aname = aname;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Applications{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                '}';
    }
}
