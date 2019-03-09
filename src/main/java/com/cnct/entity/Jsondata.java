package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/10/23.
 */
public class Jsondata implements Serializable {

    private Integer id;

    private Integer comid;

    private Integer model_id;

    private String jname;

    private String jsonstr;

    public Jsondata() {
    }

    public Jsondata(Integer id, Integer comid, Integer model_id, String jname, String jsonstr) {
        this.id = id;
        this.comid = comid;
        this.model_id = model_id;
        this.jname = jname;
        this.jsonstr = jsonstr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getJsonstr() {
        return jsonstr;
    }

    public void setJsonstr(String jsonstr) {
        this.jsonstr = jsonstr;
    }

    @Override
    public String toString() {
        return "Jsondata{" +
                "id=" + id +
                ", comid=" + comid +
                ", model_id=" + model_id +
                ", jname='" + jname + '\'' +
                ", jsonstr='" + jsonstr + '\'' +
                '}';
    }
}
