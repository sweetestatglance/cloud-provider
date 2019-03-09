package com.cnct.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangwenchao
 * 2018/9/25.
 * 企业信息、简介及管理
 */
public class CompanyInfo implements Serializable {

    private Integer comid; //企业id

    private Integer model_id; //模板id

    private String name; //企业名字

    private String type; //所属行业

    private String title; //简介标题

    private String content; //企业简介内容

    private String updatetime; //最近更新时间

    private String addtime; //建立时间

    private String freeservice; //本年度可免费服务剩余次数

    private Integer vipid; //vip套餐id

    private String mail; //公司信箱

    private String user; //企业登陆账号

    private String password; //密码

    private String wxnum; //微信号

    private String qqnum; //qq号

    private String phone; //联系电话

    private String status; //0表示否，1表示是

    public CompanyInfo() {
    }

    public CompanyInfo(Integer comid, Integer model_id, String name, String type, String title, String content, String updatetime, String addtime, String freeservice, Integer vipid, String mail, String user, String password, String wxnum, String qqnum, String phone, String status) {
        this.comid = comid;
        this.model_id = model_id;
        this.name = name;
        this.type = type;
        this.title = title;
        this.content = content;
        this.updatetime = updatetime;
        this.addtime = addtime;
        this.freeservice = freeservice;
        this.vipid = vipid;
        this.mail = mail;
        this.user = user;
        this.password = password;
        this.wxnum = wxnum;
        this.qqnum = qqnum;
        this.phone = phone;
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getFreeservice() {
        return freeservice;
    }

    public void setFreeservice(String freeservice) {
        this.freeservice = freeservice;
    }

    public Integer getVipid() {
        return vipid;
    }

    public void setVipid(Integer vipid) {
        this.vipid = vipid;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWxnum() {
        return wxnum;
    }

    public void setWxnum(String wxnum) {
        this.wxnum = wxnum;
    }

    public String getQqnum() {
        return qqnum;
    }

    public void setQqnum(String qqnum) {
        this.qqnum = qqnum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "comid=" + comid +
                ", model_id=" + model_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", addtime='" + addtime + '\'' +
                ", freeservice='" + freeservice + '\'' +
                ", vipid=" + vipid +
                ", mail='" + mail + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", wxnum='" + wxnum + '\'' +
                ", qqnum='" + qqnum + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
