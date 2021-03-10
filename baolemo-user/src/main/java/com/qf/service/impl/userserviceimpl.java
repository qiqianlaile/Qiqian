package com.qf.service.impl;

import com.qf.pojo.user.user;
import com.qf.respository.userrespository;
import com.qf.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class userserviceimpl implements userservice {
    @Autowired
    userrespository userrespository;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public String login(user user) {
        user byUsername = userrespository.findByUsername(user.getUsername());
        if(byUsername==null){
            return "没有该用户";

        }else if(!byUsername.getPassword().equals(user.getPassword())){
            return "密码错误";

        }
        UUID token = UUID.randomUUID();
         redisTemplate.opsForValue().set(token.toString(),byUsername);
         redisTemplate.expire(token.toString(),30, TimeUnit.MINUTES);
        return token.toString();
    }
}
