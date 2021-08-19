package com.sevice;

import com.Util.RedisUtil;
import com.dao.GoodDaos;
import com.dao.TagDao;
import com.dao.TypeDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.po.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class GoodseviceImpl implements Goodsevice {
    @Resource
    private GoodDaos goodDaos;
    @Resource
    private TypeDao typeDao;
    @Resource
    private TagDao tagDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public PageInfos<Good> Page(Integer starts, Integer size) {
        PageInfos<Good> info = new PageInfos<>();
        Map<String, Object> map = new HashMap<>();
        Integer start = (starts - 1) * size;
        int sizes = size * starts;
        map.put("starts",start);
        map.put("size",sizes);
        info.setCurrPage(start);
        info.setPageSize(sizes);
        Integer count = goodDaos.CountGood();
        info.setTotalCount(count);
        List<Good> pageInfo = goodDaos.listGood(map);
        info.setLists(pageInfo);
        return info;
    }

    public PageInfo<Good> PageHelperss(Integer starts, Integer size) {
        PageHelper.startPage(starts, size);
        List<Good> goodList=goodDaos.findAll();
        PageInfo<Good> pageInfo = new PageInfo<Good>(goodList);
        return pageInfo;
    }

    @Override
    public Good ById(Integer id) {
        return goodDaos.ById(id);
    }

    @Override
    public Integer delete(Integer id) {
        return goodDaos.delete(id);
    }

    @Override
    public Boolean update(Good good) {
        return goodDaos.upDate(good);
    }

    @Override
    public Integer addGood(Orders02<Good, List, Integer> good) {
        Map<String, Object> map=new HashMap<>();
        map.put("goods",good.getGood());
        map.put("good_tag",good.getTag_name());
        map.put("good_type",good.getType_name());
        return goodDaos.addGood(map);
    }

    @Override
    public Object listType(String key) {
        Map<Object, Object> goodredis = redisUtil.hmget(key);
        Orders01<Good_type, Good_tag> orders01 = new Orders01<>();
        if (goodredis==null||goodredis.size()==0) {
            synchronized (this.getClass()){
                goodredis=redisUtil.hmget(key);
                if (goodredis==null||goodredis.size()==0) {
                    List<Good_type> typeList=typeDao.findAllType();
                    List<Good_tag> tagList=tagDao.findAllTag();
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("tag",tagList);
                    map.put("type",typeList);
                    redisUtil.hmset(key,map);
                    orders01.setTlist(typeList);
                    orders01.setSlist(tagList);
                    System.out.println("mysql======"+orders01);
                    return orders01;
                }else {
                    return goodredis;
                }
            }
        }
        System.out.println("redis====="+goodredis);
        return goodredis;
    }
}
