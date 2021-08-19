package com.controller;

import com.Util.RedisUtil;
import com.github.pagehelper.PageInfo;
import com.po.*;
import com.sevice.GoodseviceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@CrossOrigin
@Controller
public class GoodController {
    @Resource
    private GoodseviceImpl goodseviceImpl;
    @Resource
    private RedisUtil redisUtil;
    @RequestMapping("/indexs")
    @ResponseBody
    public List<Good> goodPageInfo(Integer starts,Integer size) {
        PageInfos<Good> pageInfos =goodseviceImpl.Page(starts,size);
        List<Good> lists = pageInfos.getLists();
        return lists;
    }
    @RequestMapping("/pageinfo")
    @ResponseBody
    public PageInfo<Good> PageInfo(Integer starts, Integer size) {
        PageInfo<Good> pageInfos =goodseviceImpl.PageHelperss(starts,size);
        return pageInfos;
    }
    @RequestMapping("/Index")
    @ResponseBody
    public Good goodId(Integer id) {
        Good good=goodseviceImpl.ById(id);
        return good;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Integer id) {
        Integer goodDelete=goodseviceImpl.delete(id);
        return goodDelete;
    }
    @RequestMapping("/update")
    @ResponseBody
    public Boolean goodId(@RequestBody Good good) {
        goodseviceImpl.update(good);
        if(good.getG_id()==0){
            return false;
        }
        return true;
    }
    @RequestMapping("/add")
    @ResponseBody
    public Object addGood(@RequestBody Orders02<Good,List,Integer> orders02) {
//        System.out.println(orders02.toString());
        Integer good = goodseviceImpl.addGood(orders02);
        System.out.println(orders02.getGood().getG_id());
        System.out.println(good);
        return true;
    }
    @RequestMapping("/type")
    @ResponseBody
    public Object tList(String key){
        Object orders01 = goodseviceImpl.listType(key);
        return orders01;
    }
}
