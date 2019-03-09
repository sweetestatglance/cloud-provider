package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/9/25.
 * 套餐vip设置
 */
public class WebVip implements Serializable {

    private Integer vipid; //套餐vip id

    private String vipservice; //服务项说明

    private String vjson; //json

    public WebVip() {
    }

    public WebVip(Integer vipid, String vipservice, String vjson) {
        this.vipid = vipid;
        this.vipservice = vipservice;
        this.vjson = vjson;
    }

    public Integer getVipid() {
        return vipid;
    }

    public void setVipid(Integer vipid) {
        this.vipid = vipid;
    }

    public String getVipservice() {
        return vipservice;
    }

    public void setVipservice(String vipservice) {
        this.vipservice = vipservice;
    }

    public String getFee() {
        return vjson;
    }

    public void setFee(String fee) {
        this.vjson = vjson;
    }

    @Override
    public String toString() {
        return "WebVip{" +
                "vipid=" + vipid +
                ", vipservice='" + vipservice + '\'' +
                ", vjson='" + vjson + '\'' +
                '}';
    }
}
