package com.cnct.mapper;

import com.cnct.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
@Repository
public interface ModelMapper {

    @Select("select max(model_id) from model")
    @ResultType(Integer.class)
    Integer getMaxId();

    @Insert("insert into model(model_id, mname, author, seoword, describtion, pcurl, pcpath, phoneurl, phpath, tid, hid, sid, aid, cid, keyword, addtime, status, mprice, bid) " +
            "values(#{model_id}, #{mname}, #{author}, #{seoword}, #{describtion}, #{pcurl}, #{pcpath}, #{phoneurl}, #{phpath}, #{tid}, #{hid}, #{sid}, #{aid}, #{cid}," +
            " #{keyword}, str_to_date(#{addtime},'%Y-%m-%d %T'), #{status}, #{mprice}, 1)")
    @ResultType(Integer.class)
    Integer addModel(ModelBean model);

    List<ModelBean> queryModels(PageVo vo);

    Integer updateModel(ModelBean model);

    @Delete("delete from model where model_id = #{model_id}")
    @ResultType(Integer.class)
    Integer delModel(@Param("model_id") Integer model_id);

    @Select("select * from hangye")
    @ResultType(Hangye.class)
    List<Hangye> mhynavInita();

    @Select("select * from mtypes")
    @ResultType(Types.class)
    List<Types> mhynavInitb();

    Integer getAllRows(PageVo vo);

    @Select("select * from color")
    @ResultType(Colors.class)
    List<Colors> mhynavInitc();

    //-------------------------------------
    @Select("select * from model where model_id = #{model_id}")
    ModelBean getmodelbyid(@Param("model_id")Integer model_id);
}
