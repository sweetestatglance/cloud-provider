package com.cnct.controller;

import com.cnct.entity.*;
import com.cnct.mapper.ModelMapper;
import com.cnct.service.ModelService;
import com.cnct.util.DateFormatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by wangwenchao
 * 2018/9/29.
 * 模板查询
 */
@RestController
@RequestMapping("/cnctsys")
@Api("模板展示网--模板管理")
public class ModelController {

    @Autowired
    ModelService mds;

    /**
     * 网站模板行业搜索导航
     * @return
     */
    @PostMapping("/mhynavInit")
    @ApiOperation("网站模板页面初始化")
    public Map<String, Object> mhynavInit(@RequestParam(value = "currentPage") Integer currentPage,
                                          @RequestParam(value = "pageSize") Integer pageSize,
                                          @RequestParam(value = "status", required = false) Integer status) {
        Map<String, Object> map = new HashMap<>();
        PageVo vo = new PageVo();
        vo.setCurrentPage(currentPage);
        vo.setPageSize(pageSize);
        vo.setStatus(status);
        Map<String, Object> nav = new HashMap<>();
        try {
            nav = mds.mhynavInit(); //导航
            PageBean<ModelBean> pagainit = mds.queryModels(vo); //初始展示数据
            map.put("code", 200);
            map.put("msg", "查询成功！");
            map.put("serchnav", nav);
            map.put("page", pagainit);
        } catch (Exception e) {
            map.put("code", 400);
            map.put("msg", "查询失败！");
            return map;
        }
        return map;
    }

    /**
     * 编辑模板
     * @param
     * @return
     */
    @PostMapping("/editModel")
    @ApiOperation("编辑模板")
    public Map<String, Object> editModel(@RequestParam(value = "model_id", required = false) Integer model_id,
                                         @RequestParam(value = "mname", required = false) String mname,
                                         @RequestParam(value = "author", required = false) String author,
                                         @RequestParam(value = "seoword", required = false) String seoword,
                                         @RequestParam(value = "des", required = false) String des,
                                         @RequestParam(value = "pcurl", required = false) String pcurl,
                                         @RequestParam(value = "pcpath", required = false) String pcpath,
                                         @RequestParam(value = "phoneurl", required = false) String phoneurl,
                                         @RequestParam(value = "phpath", required = false) String phpath,
                                         @RequestParam(value = "tid", required = false) Integer tid,
                                         @RequestParam(value = "hid", required = false) Integer hid,
                                         @RequestParam(value = "cid", required = false) Integer cid,
                                         @RequestParam(value = "aid", required = false) Integer aid,
                                         @RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "status", required = false) Integer status,
                                         @RequestParam(value = "mprice", required = false) String mprice
    ) {
        Map<String, Object> map = new HashMap<>();
        ModelBean mb = new ModelBean(model_id, mname, author, seoword, des, pcurl, pcpath, phoneurl, phpath, tid, hid, null, 11, cid, keyword, null, mprice, status, 1);
        Integer count;
        if (model_id != null) {
            //修改
            count = mds.updateModel(mb);
        } else { //添加
            mb.setAddtime(DateFormatUtil.date_to_str(new Date()));
            count = mds.addModel(mb);
        }
        if (count > 0) {
            map.put("code", 200);
            map.put("msg", "编辑成功！");
        } else {
            map.put("code", 400);
            map.put("msg", "编辑失败!");
        }
        return map;
    }


    /**
     * 查询模板
     * @return
     */
    @PostMapping("/queryModels")
    @ApiOperation("查询模板")
    public Map<String, Object> queryModels(@RequestParam(value = "currentPage") Integer currentPage,
                                           @RequestParam(value = "pageSize") Integer pageSize,
                                           @RequestParam(value = "status", required = false) Integer status,
                                           @RequestParam(value = "tid", required = false) Integer tid,
                                           @RequestParam(value = "hid", required = false) Integer hid,
                                           @RequestParam(value = "cid", required = false) Integer cid,
                                           @RequestParam(value = "aid", required = false) Integer aid,
                                           @RequestParam(value = "keyword", required = false) String keyword,
                                           @RequestParam(value = "newst", required = false) String newst
    ) {
        Map<String, Object> map = new HashMap<>();
        PageVo vo = new PageVo();
        vo.setCurrentPage(currentPage);
        vo.setPageSize(pageSize);
        vo.setTid(tid);
        vo.setHid(hid);
        vo.setCid(cid);
        vo.setAid(aid);
        vo.setStatus(status);
        vo.setKeyword(keyword);
        if (newst != null) {
            if ("1".equals(newst)) { //1,最新
                vo.setNewst(newst);
            }
            if ("2".equals(newst)) { //2,最热
                vo.setLargest(newst);
            }
        }
        try {
            PageBean<ModelBean> pagedata = mds.queryModels(vo);
            map.put("code", 200);
            map.put("msg", "查询成功!");
            map.put("page", pagedata);
        } catch (Exception e) {
            map.put("code", 400);
            map.put("msg", "查询失败!");
            return map;
        }
        return map;
    }
//-------------------------------------------------------------
    /**
     * 查询模板
     * @return
     */
    @PostMapping("/queryModel")
    @ApiOperation("查询模板1")
    public Map<String, Object> queryModels(@RequestBody PageVo vo) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (vo.getNewst() != null) {
                if ("2".equals(vo.getNewst())) { //1,最新
                    vo.setLargest(vo.getNewst());
                    vo.setNewst(null);
                }
            }
            PageBean<ModelBean> pagedata = mds.queryModels(vo);
            map.put("code", 200);
            map.put("msg", "查询成功!");
            map.put("page", pagedata);
        } catch (Exception e) {
            map.put("code", 400);
            map.put("msg", "查询失败!");
            return map;
        }
        return map;
    }

    @Autowired
    ModelMapper moma;

    @RequestMapping("/getmodel")
    @ApiOperation("查询模板by id")
    public ModelBean getmodel(Integer model_id){
        ModelBean m = moma.getmodelbyid(model_id);
        return m;
    }
//------------------------------------------------------------------------
    /**
     * 删除模板
     * @return
     */
    @PostMapping("/delModel")
    @ApiOperation("删除模板")
    public Map<String, Object> delModel(@RequestParam(value = "model_id") Integer model_id) {
        Map<String, Object> map = new HashMap<>();
        Integer count = mds.delModel(model_id);
        if (count == 1) {
            map.put("code", 200);
            map.put("msg", "删除成功!");
        }
        if (count == 0) {
            map.put("code", 400);
            map.put("msg", "删除失败!");
        }
        return map;
    }

}
