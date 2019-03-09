package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/9/25.
 * 产品介绍（加载序列）
 */
public class ProductInfo implements Serializable {

    private Integer id; //产品id

    private Integer model_id; //属于的模板id

    private Integer comid; //属于的企业id

    private String proname; //产品名字

    private String path; //图片路径

    private Integer picid; //图片id

    private String picname; //图片名字md5

    private String des; //产品介绍

    private String price; //产品价格

    public ProductInfo() {
    }

    public ProductInfo(Integer id, Integer model_id, Integer comid, String proname, String path, Integer picid, String picname, String des, String price) {
        this.id = id;
        this.model_id = model_id;
        this.comid = comid;
        this.proname = proname;
        this.path = path;
        this.picid = picid;
        this.picname = picname;
        this.des = des;
        this.price = price;
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

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", model_id=" + model_id +
                ", comid=" + comid +
                ", proname='" + proname + '\'' +
                ", path='" + path + '\'' +
                ", picid=" + picid +
                ", picname='" + picname + '\'' +
                ", des='" + des + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
