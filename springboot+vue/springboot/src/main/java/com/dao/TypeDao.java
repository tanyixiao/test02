package com.dao;

import com.po.Good_type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeDao {
    List<Good_type> findAllType();
}
