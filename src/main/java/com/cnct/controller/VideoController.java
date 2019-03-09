package com.cnct.controller;

import com.cnct.entity.ModelBean;
import com.cnct.entity.PageBean;
import com.cnct.entity.PageVo;
import com.cnct.service.VideoService;
import com.cnct.util.DateFormatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/12/18.
 */
@RestController
@RequestMapping("/cnctsys")
@Api("模板展示网--H5管理")
public class VideoController {

    @Autowired
    VideoService vs;

    /**
     * 视频模板数据推送
     * @param
     * @return
     */
    @PostMapping("/queryVideo")
    @ApiOperation("视频模板数据推送")
    public Map<String, Object> queryVideo(@RequestParam(value = "currentPage") Integer currentPage,
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
        nav = vs.getVnav(vo);
        PageBean<ModelBean> page = vs.queryVideo(vo);
        try {
            map.put("code", 200);
            map.put("msg", "查询成功!");
            map.put("serchnav", nav);
            map.put("page", page);
        } catch (Exception e) {
            map.put("code", 400);
            map.put("msg", "查询失败!");
            return map;
        }
        return map;
    }

    /**
     * 编辑Video
     * @param
     * @return
     */
    @PostMapping("/editVideo")
    @ApiOperation("编辑H5")
    public Map<String, Object> editVideo(@RequestParam(value = "model_id", required = false) Integer model_id,
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
        ModelBean model = new ModelBean(model_id, mname, author, seoword, des, pcurl, pcpath, phoneurl, phpath, tid, hid, null, aid, cid, keyword, null, mprice, status, 4);
        Integer count;
        if (model_id != null) {
            //修改
            count = vs.updateVideo(model);
        } else { //添加
            model.setAddtime(DateFormatUtil.date_to_str(new Date()));
            count = vs.addVideo(model);
        }
        if (count > 0) {
            map.put("code", 200);
            map.put("msg", "编辑成功!");
        } else {
            map.put("code", 400);
            map.put("msg", "编辑失败!");
        }
        return map;
    }

    /**
     * 删除Video模板
     *
     * @return
     */
    @PostMapping("/delVideo")
    @ApiOperation("删除Video模板")
    public Map<String, Object> delVideo(@RequestParam(value = "model_id") Integer model_id) {
        Map<String, Object> map = new HashMap<>();
        Integer count = vs.delVideo(model_id);
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
