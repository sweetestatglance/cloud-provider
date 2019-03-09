package com.cnct.service;

import com.cnct.entity.Hangye;
import com.cnct.entity.ModelBean;
import com.cnct.entity.PageBean;
import com.cnct.entity.PageVo;

import java.util.List;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/11/14.
 */
public interface HfiveService {

    Map<String, Object> fhynavInit();

    PageBean<ModelBean> queryH5(PageVo vo);

    Integer addHfive(ModelBean model);

    Integer updateH5(ModelBean model);

    Integer delHfive(Integer model_id);

    //动态查询导航
    Map<String,Object> getNav(PageVo vo);
}
