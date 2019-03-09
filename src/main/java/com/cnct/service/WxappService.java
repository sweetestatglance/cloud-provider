package com.cnct.service;

import com.cnct.entity.ModelBean;
import com.cnct.entity.PageBean;
import com.cnct.entity.PageVo;
import com.cnct.entity.Types;

import java.util.List;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/11/14.
 */
public interface WxappService {


    Map<String,Object> wnavInit();

    PageBean<ModelBean> queryWxapp(PageVo vo);

    Integer addWxapp(ModelBean wxapp);

    Integer updateWxapp(ModelBean wxapp);

    Integer delWxapp(Integer model_id);

    Map<String,Object> getWxnav(PageVo vo);
}
