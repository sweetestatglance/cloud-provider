package com.cnct.service;

import com.cnct.entity.CompanyInfo;
import com.cnct.entity.PageBean;
import com.cnct.entity.PageVo;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
public interface ComanageService {

    /**
     * 新增客户信息
     * @param comp
     * @return
     */
    Integer addCustomer(CompanyInfo comp);

    /**
     * 根据comid查询客户
     * @param comid
     * @return
     */
    CompanyInfo getCusById(Integer comid);

    Integer resetUser(CompanyInfo com);

    PageBean<CompanyInfo> queryComs(PageVo vo);
}
