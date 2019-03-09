package com.cnct.entity;

import java.io.Serializable;

/**
 * Created by wangwenchao
 * 2018/9/25.
 * 企业网站模板
 */
public class ModelBean implements Serializable {

    private Integer model_id; //模板id

    private String mname; //模板名字

    private String author; //作者

    private String seoword; //SEO关键字

    private String describtion; //模板介绍

    private String pcurl; //pc端地址

    private String pcpath; //pc图

    private String phoneurl; //手机端地址

    private String phpath; //手机图

    private Integer tid; //所属类型

    private String tname; //类型名

    private String width; //图片的长高

    private String height;

    private Integer hid; //行业id

    private String hname; //行业名

    private Integer sid; //风格id

    private String sname; //风格名

    private Integer aid; //场景id

    private String aname; //场景名

    private Integer cid; //色系id

    private String cname; //色系名

    private String cssdata; //色彩参数

    private String keyword; //模糊查询关键字

    private String addtime; //添加时间

    private String mprice; //价格

    private Integer status; //1 显示 2 隐藏

    private Integer counts; //数量

    private Integer visites; //记录点击访问数

    private Integer bid; //模板标识

    public ModelBean() {
    }

    public ModelBean(Integer model_id, String mname, String author, String seoword, String describtion, String pcurl, String pcpath, String phoneurl, String phpath, Integer tid, Integer hid, Integer sid, Integer aid, Integer cid, String keyword, String addtime, String mprice, Integer status, Integer bid) {
        this.model_id = model_id;
        this.mname = mname;
        this.author = author;
        this.seoword = seoword;
        this.describtion = describtion;
        this.pcurl = pcurl;
        this.pcpath = pcpath;
        this.phoneurl = phoneurl;
        this.phpath = phpath;
        this.tid = tid;
        this.hid = hid;
        this.sid = sid;
        this.aid = aid;
        this.cid = cid;
        this.keyword = keyword;
        this.addtime = addtime;
        this.mprice = mprice;
        this.status = status;
        this.bid = bid;
    }

    public ModelBean(Integer model_id, String mname, String author, String seoword, String describtion, String pcurl, String pcpath, String phoneurl, String phpath, Integer tid, String tname, Integer hid, String hname, Integer sid, String sname, Integer aid, String aname, Integer cid, String cname, String cssdata, String keyword, String addtime, String mprice, Integer status, Integer counts, Integer bid) {
        this.model_id = model_id;
        this.mname = mname;
        this.author = author;
        this.seoword = seoword;
        this.describtion = describtion;
        this.pcurl = pcurl;
        this.pcpath = pcpath;
        this.phoneurl = phoneurl;
        this.phpath = phpath;
        this.tid = tid;
        this.tname = tname;
        this.hid = hid;
        this.hname = hname;
        this.sid = sid;
        this.sname = sname;
        this.aid = aid;
        this.aname = aname;
        this.cid = cid;
        this.cname = cname;
        this.cssdata = cssdata;
        this.keyword = keyword;
        this.addtime = addtime;
        this.mprice = mprice;
        this.status = status;
        this.counts = counts;
        this.bid = bid;
    }

    public Integer getModel_id() {
        return model_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeoword() {
        return seoword;
    }

    public void setSeoword(String seoword) {
        this.seoword = seoword;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getPcurl() {
        return pcurl;
    }

    public void setPcurl(String pcurl) {
        this.pcurl = pcurl;
    }

    public String getPcpath() {
        return pcpath;
    }

    public void setPcpath(String pcpath) {
        this.pcpath = pcpath;
    }

    public String getPhoneurl() {
        return phoneurl;
    }

    public void setPhoneurl(String phoneurl) {
        this.phoneurl = phoneurl;
    }

    public String getPhpath() {
        return phpath;
    }

    public void setPhpath(String phpath) {
        this.phpath = phpath;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCssdata() {
        return cssdata;
    }

    public void setCssdata(String cssdata) {
        this.cssdata = cssdata;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getMprice() {
        return mprice;
    }

    public void setMprice(String mprice) {
        this.mprice = mprice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getVisites() {
        return visites;
    }

    public void setVisites(Integer visites) {
        this.visites = visites;
    }

    @Override
    public String toString() {
        return "ModelBean{" +
                "model_id=" + model_id +
                ", mname='" + mname + '\'' +
                ", author='" + author + '\'' +
                ", seoword='" + seoword + '\'' +
                ", describtion='" + describtion + '\'' +
                ", pcurl='" + pcurl + '\'' +
                ", pcpath='" + pcpath + '\'' +
                ", phoneurl='" + phoneurl + '\'' +
                ", phpath='" + phpath + '\'' +
                ", tid=" + tid +
                ", tname='" + tname + '\'' +
                ", hid=" + hid +
                ", hname='" + hname + '\'' +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", aid=" + aid +
                ", aname='" + aname + '\'' +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cssdata='" + cssdata + '\'' +
                ", keyword='" + keyword + '\'' +
                ", addtime='" + addtime + '\'' +
                ", mprice='" + mprice + '\'' +
                ", status=" + status +
                ", counts=" + counts +
                ", visites=" + visites +
                ", bid=" + bid +
                '}';
    }
}
