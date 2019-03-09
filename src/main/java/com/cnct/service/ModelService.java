package com.cnct.service;

import com.cnct.entity.Hangye;
import com.cnct.entity.ModelBean;
import com.cnct.entity.PageBean;
import com.cnct.entity.PageVo;

import java.util.List;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
public interface ModelService {

    /**
     * 添加模板
     * @param model
     * @return
     */
    Integer addModel(ModelBean model);

    /**
     * 查询模板
     * @return
     */
    PageBean<ModelBean> queryModels(PageVo vo);

    /**
     * 修改模板
     * @param model
     * @return
     */
    Integer updateModel(ModelBean model);

    /**
     * 删除模板
     * @param model_id
     * @return
     */
    Integer delModel(Integer model_id);

    Map<String,Object> mhynavInit();
}
