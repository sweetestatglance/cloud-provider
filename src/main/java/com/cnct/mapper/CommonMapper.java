package com.cnct.mapper;

import com.cnct.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangwenchao
 * 2018/11/22.
 */
@Repository
public interface CommonMapper {


    @Select("select tname from mtypes where tid = #{tid}")
    @ResultType(String.class)
    String tnameFormodel(@Param("tid") Integer tid);

    @Select("select tname from types where tid = #{tid}")
    @ResultType(String.class)
    String tnameForHfwx(@Param("tid") Integer tid);

    @Select("select hname from hangye where hid = #{hid}")
    @ResultType(String.class)
    String getHname(@Param("hid") Integer hid);

    @Select("select aname from application where aid = #{aid}")
    @ResultType(String.class)
    String getAname(@Param("aid") Integer aid);

    @Select("select sname from style where sid = #{sid}")
    @ResultType(String.class)
    String getSname(@Param("sid") Integer sid);

    @Select("select cname from color where cid = #{cid}")
    @ResultType(String.class)
    String getCname(@Param("cid") Integer cid);

    //类型 for model
    @Select("select * from mtypes")
    @ResultType(Types.class)
    List<Types> getTypexs();

    //类型 for h5 and wxapp
    @Select("select * from types")
    @ResultType(Types.class)
    List<Types> getTypex();

    @Select("select * from hangye")
    @ResultType(Hangye.class)
    List<Hangye> getHangyex();

    @Select("select * from application")
    @ResultType(Applications.class)
    List<Applications> getScenex();

    @Select("select * from style")
    @ResultType(Styles.class)
    List<Styles> getStylex();

    //色系
    @Select("select * from color")
    @ResultType(Colors.class)
    List<Colors> getColorx();

    @Select("select model_id, pcpath, phpath from model where model_id = #{model_id}")
    @ResultType(ModelBean.class)
    ModelBean getPicurl(Integer mid);

    @Delete("delete from model where model_id = #{mid}")
    @ResultType(Integer.class)
    Integer delModelByid(@Param("mid")Integer mid);

    @Delete("delete from modelimg where imgname = #{delname}")
    @ResultType(Integer.class)
    Integer delByimgname(@Param("delname")String delname);

    @Update("update model set visites = visites + 1 where model_id = #{model_id}")
    @ResultType(Integer.class)
    Integer countVisites(@Param("model_id")Integer model_id);
}
