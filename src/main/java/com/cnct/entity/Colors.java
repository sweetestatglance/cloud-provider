package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/10/19.
 */
public class Colors implements Serializable {

    private Integer cid;

    private String cname;

    private String cssdata;

    public Colors() {
    }

    public Colors(Integer cid, String cname, String cssdata) {
        this.cid = cid;
        this.cname = cname;
        this.cssdata = cssdata;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCssdata() {
        return cssdata;
    }

    public void setCssdata(String cssdata) {
        this.cssdata = cssdata;
    }

    @Override
    public String toString() {
        return "Colors{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cssdata='" + cssdata + '\'' +
                '}';
    }
}
