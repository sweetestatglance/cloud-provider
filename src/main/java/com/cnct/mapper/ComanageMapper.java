package com.cnct.mapper;

import com.cnct.entity.CompanyInfo;
import com.cnct.entity.Jsondata;
import com.cnct.entity.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
@Repository
public interface ComanageMapper {

    @Select("select max(comid) from cominfo")
    @ResultType(Integer.class)
    Integer getMaxId();

    @Insert("insert into cominfo(comid,model_id,name,type,addtime,vipid,mail,user,password,wxnum,qqnum,phone,status) " +
            "values(#{comid},#{model_id},#{name},#{type},str_to_date(#{addtime},'%Y-%m-%d %T'),#{vipid},#{mail},#{user},#{password},#{wxnum},#{qqnum},#{phone},1)")
    @ResultType(Integer.class)
    Integer addCustomer(CompanyInfo comp);

    @Select("select comid, name, type, date_format(addtime,'%Y-%m-%d') as addtime, freeservice, vipid, mail, wxnum, qqnum, phone, status from cominfo where comid = #{comid}")
    @ResultType(CompanyInfo.class)
    CompanyInfo getCusById(Integer comid);

    @Select("select * from jsondata where model_id = #{model_id} and comid is null")
    @ResultType(Jsondata.class)
    Jsondata getModeldata(Integer model_id);

    @Select("select max(id) from jsondata")
    @ResultType(Integer.class)
    Integer getMaxIdForJsondata();

    @Insert("insert into jsondata(id,comid,model_id,jname,jsonstr) " +
            "values(#{id},#{comid},#{model_id},#{jname},#{jsonstr})")
    @ResultType(Integer.class)
    Integer addModelJson(Jsondata jnd);

    @Update("update cominfo set user = #{user}, password = #{password} where comid = #{comid}")
    @ResultType(Integer.class)
    Integer resetUser(CompanyInfo com);

    @Select("select count(1) from cominfo")
    @ResultType(Integer.class)
    Integer getTotal();

    @Select("select comid, name, type, date_format(addtime,'%Y-%m-%d') as addtime, freeservice, vipid, mail, wxnum, qqnum, phone, status from cominfo limit #{currentPage}, #{pageSize}")
    @ResultType(CompanyInfo.class)
    List<CompanyInfo> queryComs(PageVo vo);
}
