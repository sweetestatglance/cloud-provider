package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/9/29.
 * 模板展示用的图片
 */
public class ModelImg implements Serializable {

    private Integer id; //id

    private Integer model_id; //所属模板id

    private String imgname; //md5上传名

    private String originname; //原名

    private String path; //地址

    private String pcorph; //1表示pc端，0表示手机端

    public ModelImg() {
    }

    public ModelImg(Integer id, Integer model_id, String imgname, String originname, String path, String pcorph) {
        this.id = id;
        this.model_id = model_id;
        this.imgname = imgname;
        this.originname = originname;
        this.path = path;
        this.pcorph = pcorph;
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

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getOriginname() {
        return originname;
    }

    public void setOriginname(String originname) {
        this.originname = originname;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPcorph() {
        return pcorph;
    }

    public void setPcorph(String pcorph) {
        this.pcorph = pcorph;
    }

    @Override
    public String toString() {
        return "ModelImg{" +
                "id=" + id +
                ", model_id=" + model_id +
                ", imgname='" + imgname + '\'' +
                ", originname='" + originname + '\'' +
                ", path='" + path + '\'' +
                ", pcorph='" + pcorph + '\'' +
                '}';
    }
}
