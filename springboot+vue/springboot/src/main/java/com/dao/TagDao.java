package com.dao;

import com.po.Good_tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagDao {

    List<Good_tag> findAllTag();
}
