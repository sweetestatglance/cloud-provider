package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/9/25.
 * 图片存储信息
 */
public class PictureInfo implements Serializable {

    private Integer picid; //图片id

    private Integer comid; //企业id

    private Integer model_id; //模板id

    private Integer module; //模块id

    private String path; //图片路径

    private String picname; //图片名称md5

    private String picorigin; //图片的原名称

    public PictureInfo() {
    }

    public PictureInfo(Integer picid, Integer comid, Integer model_id, Integer module, String path, String picname, String picorigin) {
        this.picid = picid;
        this.comid = comid;
        this.model_id = model_id;
        this.module = module;
        this.path = path;
        this.picname = picname;
        this.picorigin = picorigin;
    }

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public Integer getModel_id() {
        return model_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname;
    }

    public String getPicorigin() {
        return picorigin;
    }

    public void setPicorigin(String picorigin) {
        this.picorigin = picorigin;
    }

    @Override
    public String toString() {
        return "PictureInfo{" +
                "picid=" + picid +
                ", comid=" + comid +
                ", model_id=" + model_id +
                ", module=" + module +
                ", path='" + path + '\'' +
                ", picname='" + picname + '\'' +
                ", picorigin='" + picorigin + '\'' +
                '}';
    }
}
