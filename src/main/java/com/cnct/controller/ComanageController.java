package com.cnct.controller;

import com.cnct.entity.CompanyInfo;
import com.cnct.entity.PageBean;
import com.cnct.entity.PageVo;
import com.cnct.entity.StaticValue;
import com.cnct.service.ComanageService;
import com.cnct.util.DateFormatUtil;
import com.cnct.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
@RestController
@RequestMapping("/cnctsys")
@Api("模板展示网--客户管理")
public class ComanageController {

    @Autowired
    ComanageService cgse;

    /**
     * 新增客户
     * @param comp
     * @return
     */
    @PostMapping("/addCustomer")
    @ApiOperation("新增客户信息")
    public Map<String,Object> addCustomer(@RequestBody CompanyInfo comp){
        Map<String,Object> map = new HashMap<>();
        comp.setAddtime(DateFormatUtil.date_to_str(new Date()));
        Integer count = cgse.addCustomer(comp);
        if (count == 1){
            map.put("code",200);
            map.put("msg","添加成功!");
        }else {
            map.put("code",400);
            map.put("msg","添加失败!");
        }
        return map;
    }

    /**
     * 分页查询客户
     * @param currentPage
     * @param pageSize
     * @return
     */
    @PostMapping("/queryComs")
    @ApiOperation("分页查询客户")
    public Map<String,Object> queryComs(@RequestParam(value = "currentPage") Integer currentPage,
                                        @RequestParam(value = "pageSize") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        PageVo vo = new PageVo();
        vo.setCurrentPage(currentPage);
        vo.setPageSize(pageSize);
        try {
            PageBean<CompanyInfo> page = cgse.queryComs(vo);
            map.put("code", 200);
            map.put("msg", "查询成功!");
            map.put("page", page);
        } catch (Exception e) {
            map.put("code", 400);
            map.put("msg", "查询失败!");
            return map;
        }
        return map;
    }

    /**
     * 根据comid查询客户
     * @param cid
     * @return
     */
    @PostMapping("/getCusById")
    @ApiOperation("根据comid查询客户")
    public Map<String,Object> getCusById(@RequestParam("cid") String cid){
        Map<String,Object> map = new HashMap<>();
        Integer comid = Integer.parseInt(cid);
        CompanyInfo cop = cgse.getCusById(comid);
        if (cop != null){
            map.put("code",200);
            map.put("msg","查询成功!");
            map.put("res",cop);
        }else {
            map.put("code",400);
            map.put("msg","添加失败!");
        }
        return map;
    }

    /**
     * 重置用户账号密码
     * @param
     * @return
     */
    @PostMapping("/resetUser")
    @ApiOperation("重置用户账号密码")
    public Map<String,Object> resetUser(@RequestParam("comid") Integer comid,
                                        @RequestParam("user") String user,
                                        @RequestParam("password") String password) {
        Map<String, Object> map = new HashMap<>();
        CompanyInfo com = new CompanyInfo();
        com.setComid(comid);
        com.setUser(MD5Util.MD5(user + StaticValue.USER));
        com.setPassword(MD5Util.MD5(password + StaticValue.PASSWORD));
        Integer count = cgse.resetUser(com);
        if (count > 0){
            map.put("code",200);
            map.put("msg","重置成功!");
        }else {
            map.put("code",200);
            map.put("msg","重置失败!");
        }
        return map;
    }

    /**
     * 修改服务次数，管理员对各企业的套餐服务进行核对
     */
}
