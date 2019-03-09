package com.cnct.mapper;

import com.cnct.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangwenchao
 * 2018/11/14.
 */
@Repository
public interface HfiveMapper {

    @Select("select max(model_id) from model")
    @ResultType(Integer.class)
    Integer getMaxId();

    @Insert("insert into model(model_id, mname, author, seoword, describtion, pcurl, pcpath, phoneurl, phpath, tid, hid, sid, aid, cid, keyword, addtime, status, mprice, bid) " +
            "values(#{model_id}, #{mname}, #{author}, #{seoword}, #{describtion}, #{pcurl}, #{pcpath}, #{phoneurl}, #{phpath}, #{tid}, #{hid}, #{sid}, #{aid}, #{cid}," +
            " #{keyword}, str_to_date(#{addtime},'%Y-%m-%d %T'), #{status}, #{mprice}, #{bid})")
    @ResultType(Integer.class)
    Integer addHfive(ModelBean model);

    @Select("select * from hangye")
    @ResultType(Hangye.class)
    List<Hangye> fhynavInit();

    List<ModelBean> queryH5(PageVo vo);

    Integer getAllRows(PageVo vo);

    @Select("select tid from types where tname like concat('%',#{keyword},'%')")
    @ResultType(Integer.class)
    Integer getTid(@Param("keyword") String keyword);

    Integer updateH5(ModelBean model);

    @Delete("delete from model where model_id = #{model_id}")
    @ResultType(Integer.class)
    Integer delHfive(@Param("model_id") Integer model_id);

    @Select("select * from hangye")
    @ResultType(Hangye.class)
    List<Hangye> fhynavInita();

    @Select("select * from mtypes")
    @ResultType(Types.class)
    List<Types> fhynavInitb();

    @Select("select * from color")
    @ResultType(Colors.class)
    List<Colors> fhynavInitc();

    List<Applications> getScene(PageVo vo);

    List<Applications> getAppli();
}
