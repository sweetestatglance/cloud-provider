package com.cnct.controller;

import com.cnct.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/11/26.
 */
@RestController
@RequestMapping("/cnctsys")
@Api("模板展示网--公共接口")
public class CommonController {

    @Autowired
    CommonService cs;

    /**
     * 下拉选数据for model
     * @return
     */
    @PostMapping("/selecForModel")
    @ApiOperation("下拉选数据for model")
    public Map<String,Object> selecForModel(){
        Map<String,Object> map = new HashMap<>();
        try {
            Map<String,Object> pulldown = cs.selecForModel();
            map.put("code", 200);
            map.put("msg", "查询成功!");
            map.put("res",pulldown);
        } catch (Exception e) {
            map.put("code", 400);
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 下拉选数据for h5/wxapp
     * @return
     */
    @PostMapping("/selecForHfwx")
    @ApiOperation("下拉选数据for h5/wxapp")
    public Map<String,Object> selecForHfwx(){
        Map<String,Object> map = new HashMap<>();
        try {
            Map<String,Object> pulldown = cs.selecForHfwx();
            map.put("code", 200);
            map.put("msg", "查询成功!");
             map.put("res",pulldown);
        } catch (Exception e) {
            map.put("code", 400);
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 删除模板（多条）
     * @param mids
     * @return
     */
    @PostMapping("/delMdByids")
    @ApiOperation("删除模板(多条)")
    public Map<String,Object> delMdByids(@RequestParam("mids") String mids){
        Map<String,Object> map = new HashMap<>();
        if (mids == null || mids == ""){
            map.put("code",400);
                map.put("msg","请选择要删除的模板!");
            return  map;
        }
        String[] idx = mids.split("-");
        Integer[] ids = new Integer[idx.length];
        for (int i = 0;i < idx.length;i ++){
            ids[i] = Integer.parseInt(idx[i]);
        }
        boolean isok = cs.delMdByids(ids);
        if (isok){
            map.put("code",200);
            map.put("msg","删除成功!");
        }else {
            map.put("code",400);
            map.put("msg","删除失败!");
        }
        return map;
    }

    /**
     * 浏览访问计数
     * @param model_id
     * @return
     */
    @PostMapping("/countVisites")
    @ApiOperation("浏览访问计数")
    public void countVisites(@RequestParam(value = "model_id") Integer model_id){
        //Map<String,Object> map = new HashMap<>();
        try {
            Integer count = cs.countVisites(model_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return map;
    }
}
