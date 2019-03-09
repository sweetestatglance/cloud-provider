package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/11/26.
 */
public class Ctype implements Serializable {

    private Integer biaoshi; //1 类型；2 行业；3 场景；4风格

    private Integer id; //相应数据的id，如new Ctype(3,2,"xxx"),场景：hid=2，hname=“xxx”

    private String name; //相应数据的name

    public Ctype() {
    }

    public Ctype(Integer biaoshi, Integer id, String name) {
        this.biaoshi = biaoshi;
        this.id = id;
        this.name = name;
    }

    public Integer getBiaoshi() {
        return biaoshi;
    }

    public void setBiaoshi(Integer biaoshi) {
        this.biaoshi = biaoshi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ctype{" +
                "biaoshi=" + biaoshi +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


