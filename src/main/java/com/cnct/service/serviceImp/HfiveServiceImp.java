package com.cnct.service.serviceImp;

import com.cnct.entity.*;
import com.cnct.mapper.HfiveMapper;
import com.cnct.mapper.ModelMapper;
import com.cnct.service.CommonService;
import com.cnct.service.HfiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/11/14.
 */
@Service
public class HfiveServiceImp implements HfiveService {

    @Autowired
    HfiveMapper hfm;

    @Autowired
    CommonService common;

    @Override
    public Map<String, Object> fhynavInit() {
        Map<String,Object> nav = new HashMap<>();
        List<Hangye> hangye = hfm.fhynavInita(); //行业
        //List<Types> type = hfm.fhynavInitb(); //类型
        List<Colors> color = hfm.fhynavInitc(); //色系
        List<Applications> scene = hfm.getAppli(); //场景
        nav.put("hangye",hangye);
        //nav.put("type",type);
        nav.put("color",color);
        nav.put("scene",scene);
        return nav;
    }

    /**
     * 分页查询
     * @param vo
     * @return
     */
    @Override
    public PageBean<ModelBean> queryH5(PageVo vo) {
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
        list = hfm.queryH5(vo);
        pagelist.setList(list); //查询的该页数据
        return pagelist;
    }

    /**
     * 添加H5模板
     * @param model
     * @return
     */
    @Override
    @Transactional
    public Integer addHfive(ModelBean model) {
        Integer id = hfm.getMaxId();
        model.setModel_id(id + 1);
        String keyw = common.keyForHfwx(model);
        model.setKeyword(keyw);
        return hfm.addHfive(model);
    }

    /**
     * 修改H5模板
     * @param model
     * @return
     */
    @Override
    @Transactional
    public Integer updateH5(ModelBean model) {
        return hfm.updateH5(model);
    }

    /**
     * 删除H5模板
     * @param model_id
     * @return
     */
    @Override
    @Transactional
    public Integer delHfive(Integer model_id) {
        return hfm.delHfive(model_id);
    }

    /**
     * 动态查询导航
     * @param vo
     * @return
     */
    @Override
    public Map<String, Object> getNav(PageVo vo) {
        Map<String,Object> nav = fhynavInit(); //行业，类型，色系
        if (vo.getHid() != null){ //如果hid为null 则返回初始化数据 不为null 去查对应的场景
            //场景
            List<Applications> scene = hfm.getScene(vo);
            //List<Applications> scene = hfm.getAppli();
            nav.put("scene",scene);
        }
        return nav;
    }


    //================功能函数=============================

    //查总数
    private Integer getAllRows(PageVo vo){
        Integer rows = hfm.getAllRows(vo);
        return rows;
    }

    private Integer getTid(String keyword){
        Integer tid = hfm.getTid(keyword);
        return tid;
    }
}
