package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/9/25.
 * 模块
 */
public class Module implements Serializable {

    private Integer module; //模块id

    private String name; //模块名字

    public Module() {
    }

    public Module(Integer module, String name) {
        this.module = module;
        this.name = name;
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Module{" +
                "module=" + module +
                ", name='" + name + '\'' +
                '}';
    }
}
