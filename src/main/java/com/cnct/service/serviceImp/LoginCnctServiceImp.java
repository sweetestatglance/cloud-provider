package com.cnct.service.serviceImp;

import com.cnct.entity.Cncter;
import com.cnct.entity.CompanyInfo;
import com.cnct.mapper.LoginCnctMapper;
import com.cnct.service.LoginCnctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
@Service
public class LoginCnctServiceImp implements LoginCnctService {

    @Autowired
    LoginCnctMapper lcm;

    /**
     * 登陆验证
     * @param cnc
     * @return
     */
    @Override
    public Integer loginCnct(Cncter cnc) {
        return lcm.loginCnct(cnc);
    }

}
