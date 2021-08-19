package com.sevice;
import com.github.pagehelper.PageInfo;
import com.po.*;

import java.util.List;

public interface Goodsevice {

    PageInfos<Good> Page(Integer starts, Integer size);

    Good ById(Integer id);

    Boolean update(Good good);
    PageInfo<Good> PageHelperss(Integer starts,Integer size);

    Integer delete(Integer id);

    Integer addGood(Orders02<Good, List, Integer> good);

    Object listType(String key);
}
