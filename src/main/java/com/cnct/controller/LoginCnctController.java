package com.cnct.controller;

import com.cnct.entity.Cncter;
import com.cnct.entity.CompanyInfo;
import com.cnct.entity.StaticValue;
import com.cnct.service.LoginCnctService;
import com.cnct.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
@RestController
@RequestMapping("/cnctsys")
@Api("模板展示网--管理登陆")
public class LoginCnctController {

    @Autowired
    LoginCnctService lcs;

    /**
     * 登陆验证
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/loginCnct")
    @ApiOperation("登陆验证")
    public Map<String,Object> loginCnct(@RequestParam("username") String username,
                                        @RequestParam("password") String password){
        Map<String,Object> map = new HashMap<>();
        Cncter cnc = new Cncter();
        cnc.setUsername(username);
        cnc.setPassword(password);
        cnc.setPassword(password);
        //与加密字符串组合再md5
        cnc.setUsername(MD5Util.MD5(cnc.getUsername() + StaticValue.USER));
        cnc.setPassword(MD5Util.MD5(cnc.getPassword() + StaticValue.PASSWORD));
        Integer count = lcs.loginCnct(cnc);
        if (count == 1){
            map.put("code",200);
            map.put("msg","登陆成功!");
        }
        if (count == 0){
            map.put("code",400);
            map.put("msg","用户名或者密码错误");
        }
        return map;
    }

}
