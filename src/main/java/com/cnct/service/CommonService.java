package com.cnct.service;

import com.cnct.entity.ModelBean;

import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/11/22.
 */
public interface CommonService {

    String keyForHfwx(ModelBean model);

    String KeyForModel(ModelBean model);

    //类型、等下拉选 for model
    Map<String,Object> selecForModel();

    //for h5 and wxapp
    Map<String,Object> selecForHfwx();

    boolean delMdByids(Integer[] ids);

    Integer countVisites(Integer model_id);
}
