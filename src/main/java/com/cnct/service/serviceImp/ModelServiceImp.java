package com.cnct.service.serviceImp;

import com.cnct.entity.*;
import com.cnct.mapper.ModelMapper;
import com.cnct.service.CommonService;
import com.cnct.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
@Service
public class ModelServiceImp implements ModelService {

    @Autowired
    ModelMapper moma;

    @Autowired
    CommonService common;

    /**
     * 添加模板
     * @param model
     * @return
     */
    @Override
    @Transactional
    public Integer addModel(ModelBean model) {
        Integer maxid = moma.getMaxId();
        model.setModel_id(maxid + 1);
        String keyw = common.KeyForModel(model);
        model.setKeyword(keyw);
        return moma.addModel(model);
    }

    /**
     * 查询模板
     * @return
     */
    @Override
    @Cacheable(value = "md_cache",key = "#vo.currentPage.toString() + '_md'")
    public PageBean<ModelBean> queryModels(PageVo vo) {
        PageBean<ModelBean> pagelist = new PageBean<ModelBean>();
        pagelist.setCurrentPage(vo.getCurrentPage()); //当前页
        List<ModelBean> list = new ArrayList<>();
        int pagesize = vo.getPageSize();
        int serpoint = (vo.getCurrentPage() - 1) * pagesize; //转成分页查询下标
        vo.setCurrentPage(serpoint);
        pagelist.setPageSize(vo.getPageSize()); //每页大小
        int rows = getAllRows(vo);
        pagelist.setTotalRows(rows); //查询总数
        pagelist.setTotalPages((int) Math.ceil((double)rows / (double)pagesize)); //总页数 ceil向上取整
        list = moma.queryModels(vo);
        pagelist.setList(list); //查询的该页数据
        return pagelist;
    }

    /**
     * 修改模板
     * @param model
     * @return
     */
    @Override
    @Transactional
    public Integer updateModel(ModelBean model) {
        return moma.updateModel(model);
    }

    /**
     * 删除模板
     * @param model_id
     * @return
     */
    @Override
    @Transactional
    public Integer delModel(Integer model_id) {
        return moma.delModel(model_id);
    }

    @Override
    public Map<String,Object> mhynavInit() {
        Map<String,Object> nav = new HashMap<>();
        List<Hangye> hangye = moma.mhynavInita(); //行业
        List<Types> type = moma.mhynavInitb(); //类型
        List<Colors> color = moma.mhynavInitc(); //色系
        nav.put("hangye",hangye);
        nav.put("type",type);
        nav.put("color",color);
        return nav;
    }

    //================功能函数=============================

    //查总数
    private Integer getAllRows(PageVo vo){
        Integer rows = moma.getAllRows(vo);
        return rows;
    }

}
