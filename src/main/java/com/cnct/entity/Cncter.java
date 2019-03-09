package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
public class Cncter implements Serializable {

    private Integer id;

    private String username;

    private String password;

    public Cncter() {
    }

    public Cncter(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cncter{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
