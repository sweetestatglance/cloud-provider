package com.cnct.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangwenchao
 * 2018/11/12.
 */
public class PageBean<T> implements Serializable {

    private Integer currentPage;//当前页

    private Integer pageSize;//每页大小，显示大小

    private Integer totalPages;//总的页数 = math.ceil(totalRows / pageSize);ceil向上取整

    private Integer totalRows;//所查条件下的所有查询到的条数（总数）

    private List<T> list;//每页显示的占位对象 T

    public PageBean() {
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer totalPages, Integer totalRows, List<T> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalRows = totalRows;
        this.list = list;
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

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", totalRows=" + totalRows +
                ", list=" + list +
                '}';
    }
}
