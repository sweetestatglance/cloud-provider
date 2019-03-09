package com.cnct.controller;

import com.cnct.entity.Hangye;
import com.cnct.entity.ModelBean;
import com.cnct.entity.PageBean;
import com.cnct.entity.PageVo;
import com.cnct.service.HfiveService;
import com.cnct.util.DateFormatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by wangwenchao
 * 2018/11/14.
 */
@RestController
@RequestMapping("/cnctsys")
@Api("模板展示网--H5管理")
public class HfiveController {

    @Autowired
    HfiveService hfc;

    /**
     * H5模板行业搜索导航
     *
     * @return
     */
    @PostMapping("/fhynavInit")
    //@ApiOperation("H5模板页面初始化")
    public Map<String, Object> fhynavInit(@RequestParam(value = "currentPage") Integer currentPage,
                                          @RequestParam(value = "pageSize") Integer pageSize,
                                          @RequestParam(value = "status", required = false) Integer status) {
        Map<String, Object> map = new HashMap<>();
        PageVo vo = new PageVo();
        vo.setCurrentPage(currentPage);
        vo.setPageSize(pageSize);
        vo.setStatus(status);
        Map<String, Object> nav = new HashMap<>();
        try {
            nav = hfc.fhynavInit();
            PageBean<ModelBean> pagainit = hfc.queryH5(vo);
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
     * H5模板数据推送
     *
     * @param
     * @return
     */
    @PostMapping("/queryH5")
    @ApiOperation("H5模板数据推送")
    public Map<String, Object> queryH5(@RequestParam(value = "currentPage") Integer currentPage,
                                       @RequestParam(value = "pageSize") Integer pageSize,
                                       @RequestParam(value = "status", required = false) Integer status,
                                       @RequestParam(value = "tid", required = false) Integer tid,
                                       @RequestParam(value = "hid", required = false) Integer hid,
                                       @RequestParam(value = "cid", required = false) Integer cid,
                                       @RequestParam(value = "aid", required = false) Integer aid,
                                       @RequestParam(value = "keyword", required = false) String keyword,
                                       @RequestParam(value = "newst", required = false) String newst) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> nav = new HashMap<>();
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
        nav = hfc.getNav(vo);
        PageBean<ModelBean> page = hfc.queryH5(vo);
        try {
            map.put("code", 200);
            map.put("msg", "查询成功!");
            map.put("serchnav", nav);
            map.put("page", page);
        } catch (Exception e) {
            map.put("code", 400);
            map.put("msg", "查询失败！");
            return map;
        }
        return map;
    }

    /**
     * 编辑H5
     * @param
     * @return
     */
    @PostMapping("/editHfive")
    @ApiOperation("编辑H5")
    public Map<String, Object> editHfive(@RequestParam(value = "model_id", required = false) Integer model_id,
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
        ModelBean mb = new ModelBean(model_id, mname, author, seoword, des, pcurl, pcpath, phoneurl, phpath, tid, hid, null, aid, cid, keyword, null, mprice, status, 2);
        Integer count;
        if (model_id != null) {
            //修改
            count = hfc.updateH5(mb);
        } else { //添加
            mb.setAddtime(DateFormatUtil.date_to_str(new Date()));
            count = hfc.addHfive(mb);
        }
        if (count > 0) {
            map.put("code", 200);
            map.put("msg", "编辑成功!");
        } else {
            map.put("code", 400);
            map.put("msg", "编辑失败！");
        }
        return map;
    }

    /**
     * 添加H5模板
     *
     * @param
     * @return
     */

    @PostMapping("/editHfive1")
    //@ApiOperation("添加H5模板")
    public Map<String, Object> editHfive(@RequestParam(value = "model_id", required = false) Integer model_id,
                                         @RequestParam(value = "mname", required = false) String mname,
                                         @RequestParam(value = "des", required = false) String des,
                                         @RequestParam(value = "pcurl", required = false) String pcurl,
                                         @RequestParam(value = "pcpath", required = false) String pcpath,
                                         @RequestParam(value = "phoneurl", required = false) String phoneurl,
                                         @RequestParam(value = "phpath", required = false) String phpath,
                                         @RequestParam(value = "addtime", required = false) String addtime,
                                         @RequestParam(value = "tid", required = false) Integer tid,
                                         @RequestParam(value = "hid", required = false) Integer hid,
                                         @RequestParam(value = "cid", required = false) Integer cid,
                                         @RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "mprice", required = false) String mprice
    ) {
        Map<String, Object> map = new HashMap<>();
        ModelBean model = new ModelBean(model_id, mname, null, null, des, pcurl, pcpath, phoneurl, phpath, tid, null, hid, null, null, null, null, null, cid, null, null, keyword, addtime, mprice, null, null,2);
        model.setAddtime(DateFormatUtil.date_to_str(new Date()));
        Integer count = hfc.addHfive(model);
        if (count == 1) {
            map.put("code", 200);
            map.put("msg", "添加成功!");
        }
        if (count == 0) {
            map.put("code", 400);
            map.put("msg", "添加失败!");
        }
        return map;
    }

    /**
     * 修改H5模板
     *
     * @return
     */
    @PostMapping("/updateH5")
    //@ApiOperation("修改H5模板")
    public Map<String, Object> updateH5(@RequestBody ModelBean model) {
        Map<String, Object> map = new HashMap<>();
        Integer count = hfc.updateH5(model);
        if (count == 1) {
            map.put("code", 200);
            map.put("msg", "修改成功!");
        }
        if (count == 0) {
            map.put("code", 400);
            map.put("msg", "修改失败!");
        }
        return map;
    }

    /**
     * 删除H5模板
     *
     * @return
     */
    @PostMapping("/delHfive")
    @ApiOperation("删除H5模板")
    public Map<String, Object> delHfive(@RequestParam(value = "model_id") Integer model_id) {
        Map<String, Object> map = new HashMap<>();
        Integer count = hfc.delHfive(model_id);
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
