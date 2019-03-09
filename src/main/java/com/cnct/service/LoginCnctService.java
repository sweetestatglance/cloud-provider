package com.cnct.service;

import com.cnct.entity.Cncter;
import com.cnct.entity.CompanyInfo;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
public interface LoginCnctService {

    /**
     * 登陆验证
     * @param cnc
     * @return
     */
    Integer loginCnct(Cncter cnc);

}
