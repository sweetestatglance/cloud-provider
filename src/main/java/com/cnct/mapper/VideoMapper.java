package com.cnct.mapper;

import com.cnct.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangwenchao
 * 2018/12/18.
 */
@Repository
public interface VideoMapper {

    @Select("select max(model_id) from model")
    @ResultType(Integer.class)
    Integer getMaxId();

    @Select("select * from hangye")
    @ResultType(Hangye.class)
    List<Hangye> vhinit();

    @Select("select * from color")
    @ResultType(Colors.class)
    List<Colors> vcinit();

    @Insert("insert into model(model_id, mname, author, seoword, describtion, pcurl, pcpath, phoneurl, phpath, tid, hid, sid, aid, cid, keyword, addtime, status, mprice, bid) " +
            "values(#{model_id}, #{mname}, #{author}, #{seoword}, #{describtion}, #{pcurl}, #{pcpath}, #{phoneurl}, #{phpath}, #{tid}, #{hid}, #{sid}, #{aid}, #{cid}," +
            " #{keyword}, str_to_date(#{addtime},'%Y-%m-%d %T'), #{status}, #{mprice}, #{bid})")
    @ResultType(Integer.class)
    Integer addVideo(ModelBean model);

    Integer updateVideo(ModelBean model);

    @Delete("delete from model where model_id = #{model_id}")
    @ResultType(Integer.class)
    Integer delVideo(@Param("model_id") Integer model_id);

    Integer getAllRows(PageVo vo);

    List<Applications> getSceney(PageVo vo);

    List<Applications> getScenen(PageVo vo);

    List<ModelBean> queryVideo(PageVo vo);
}
