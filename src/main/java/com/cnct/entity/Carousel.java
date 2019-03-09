package com.cnct.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangwenchao
 * 2018/9/25.
 * 首页轮播（播放序列）
 */
public class Carousel implements Serializable {

    private Integer id; //轮播id

    private Integer model_id; //模板id

    private Integer comid; //企业id

    private String prefixpath; //轮播图路径（只路径）

    private String picname; //图片名字，用“-”连接

    private String updatetime; //最近更新时间

    public Carousel() {
    }

    public Carousel(Integer id, Integer model_id, Integer comid, String prefixpath, String picname, String updatetime) {
        this.id = id;
        this.model_id = model_id;
        this.comid = comid;
        this.prefixpath = prefixpath;
        this.picname = picname;
        this.updatetime = updatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModel_id() {
        return model_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getPrefixpath() {
        return prefixpath;
    }

    public void setPrefixpath(String prefixpath) {
        this.prefixpath = prefixpath;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", model_id=" + model_id +
                ", comid=" + comid +
                ", prefixpath='" + prefixpath + '\'' +
                ", picname='" + picname + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
