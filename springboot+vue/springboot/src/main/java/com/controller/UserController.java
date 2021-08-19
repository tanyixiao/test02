package com.controller;

import com.Util.RedisUtil;
import com.po.CommonResult;
import com.po.User;
import com.sevice.userseviceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@CrossOrigin
@Controller
public class UserController {
    @Resource
    private userseviceImpl userseviceImpl;
    @Resource
    private RedisUtil redisUtil;
    @RequestMapping("/user")
    @ResponseBody
    public Object user(User user, Model model) {
        User user1 = userseviceImpl.Bypwd(user);
        if(user1!=null){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/set")
    @ResponseBody
    public Object Rediscontroller(User user){
        return userseviceImpl.add(user.getName(), user.getPassword());

    }
    @RequestMapping("/get")
    @ResponseBody
    public Object Rediscontroller02(User user){
        ExecutorService pool = Executors.newFixedThreadPool(200);
        for ( int i=1;i<500;i++){
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    Object key = userseviceImpl.finAllKey(user);
                    System.out.println(key);
                }
            });
        }

        return userseviceImpl.finAllKey(user);
    }
}
