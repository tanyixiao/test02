package com.sevice;

import com.Util.RedisUtil;
import com.dao.userDao;
import com.po.User;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class userseviceImpl implements usersevier {
    @Resource
    userDao userDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public User Bypwd(User user) {
        return userDao.Bypwd(user);
    }

    @Override
    public Integer add(String name, Integer password) {
        Integer add = userDao.add(name, password);
        return add;
    }
    @Transient
    public Object finAllKey(User user){
        Object redisObj = redisUtil.get(user.getName());
        if (redisObj == null) {
            synchronized (this.getClass()){
                 redisObj = redisUtil.get(user.getName());
                if (redisObj==null){
                    User user1 = userDao.Bypwd(user);
                    redisUtil.set(user.getName(),user.getPassword());
                    return "查询mysql数据库======" + user1;
                } else {
                    return "查询redis数据库======"+redisObj;
                }
            }
        }else {
            return "查询redis数据库======"+redisObj;
        }
    }
}
