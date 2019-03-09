package com.cnct.service;

import com.cnct.entity.ModelBean;
import com.cnct.entity.PageBean;
import com.cnct.entity.PageVo;

import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/12/18.
 */
public interface VideoService {

    //导航
    Map<String,Object> getVnav(PageVo vo);

    //数据
    PageBean<ModelBean> queryVideo(PageVo vo);

    //修改
    Integer updateVideo(ModelBean mb);

    //插入
    Integer addVideo(ModelBean mb);

    //删除
    Integer delVideo(Integer model_id);
}
