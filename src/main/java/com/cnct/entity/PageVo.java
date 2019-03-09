package com.cnct.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wangwenchao
 * 2018/11/12.
 */
public class PageVo implements Serializable {

    private Integer currentPage;//当前页

    private Integer pageSize;//每页大小，显示大小

    private String keyword; //模糊查询关键字

    private String newst; //是否查最新

    private String largest; //是否查最多

    private Integer model_id; //模板id

    private Integer tid; //所属类型

    private Integer hid; //行业id

    private Integer sid; //风格id

    private Integer aid; //用途id

    private Integer cid; //色系id

    private Integer status; //1 显示，2隐藏

    private Integer visites; //记录点击访问数

    private Integer bid; //模板标识

    public PageVo() {
    }

    public PageVo(Integer currentPage, Integer pageSize, String keyword, String newst, String largest, Integer model_id, Integer tid, Integer hid, Integer sid, Integer aid, Integer cid, Integer status, Integer bid) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.newst = newst;
        this.largest = largest;
        this.model_id = model_id;
        this.tid = tid;
        this.hid = hid;
        this.sid = sid;
        this.aid = aid;
        this.cid = cid;
        this.status = status;
        this.bid = bid;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getNewst() {
        return newst;
    }

    public void setNewst(String newst) {
        this.newst = newst;
    }

    public String getLargest() {
        return largest;
    }

    public void setLargest(String largest) {
        this.largest = largest;
    }

    public Integer getModel_id() {
        return model_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVisites() {
        return visites;
    }

    public void setVisites(Integer visites) {
        this.visites = visites;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", keyword='" + keyword + '\'' +
                ", newst='" + newst + '\'' +
                ", largest='" + largest + '\'' +
                ", model_id=" + model_id +
                ", tid=" + tid +
                ", hid=" + hid +
                ", sid=" + sid +
                ", aid=" + aid +
                ", cid=" + cid +
                ", status=" + status +
                ", visites=" + visites +
                ", bid=" + bid +
                '}';
    }
}
