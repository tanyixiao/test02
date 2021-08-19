package com.dao;

import com.po.Good;
import com.po.Good_tag;
import com.po.Good_type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodDaos {
    List<Good> listGood(Map<String, Object> map);
    Integer CountGood();

    Good ById(Integer id);

    Boolean upDate(Good good);

    List<Good> findAll();

    Integer delete(Integer id);

    Integer addGood(Map<String, Object> map);

}
