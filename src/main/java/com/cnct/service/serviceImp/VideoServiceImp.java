package com.cnct.service.serviceImp;

import com.cnct.entity.*;
import com.cnct.mapper.VideoMapper;
import com.cnct.service.CommonService;
import com.cnct.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/12/18.
 */
@Service
public class VideoServiceImp implements VideoService {

    @Autowired
    VideoMapper vm;

    @Autowired
    CommonService common;

    /**
     * 导航
     * @param vo
     * @return
     */
    @Override
    public Map<String, Object> getVnav(PageVo vo) {
        Map<String,Object> nav = new HashMap<>();
        List<Applications> scene;
        List<Hangye> hangye = vm.vhinit(); //行业
        List<Colors> color = vm.vcinit(); //色系
        if (vo.getHid() != null){
            scene = vm.getSceney(vo);
        }else {
            scene = vm.getScenen(vo);
        }
        nav.put("hangye",hangye);
        nav.put("color",color);
        nav.put("scene",scene);
        return nav;
    }

    /**
     * 数据
     * @param vo
     * @return
     */
    @Override
    public PageBean<ModelBean> queryVideo(PageVo vo) {
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
        list = vm.queryVideo(vo);
        pagelist.setList(list); //查询的该页数据
        return pagelist;
    }

    //修改
    @Override
    @Transactional
    public Integer updateVideo(ModelBean model) {
        return vm.updateVideo(model);
    }

    //插入
    @Override
    @Transactional
    public Integer addVideo(ModelBean model) {
        Integer id = vm.getMaxId();
        model.setModel_id(id + 1);
        String keyw = common.keyForHfwx(model);
        model.setKeyword(keyw);
        return vm.addVideo(model);
    }

    @Override
    public Integer delVideo(Integer model_id) {
        return vm.delVideo(model_id);
    }


    //================功能函数=============================

    //查总数
    private Integer getAllRows(PageVo vo){
        Integer rows = vm.getAllRows(vo);
        return rows;
    }

}
