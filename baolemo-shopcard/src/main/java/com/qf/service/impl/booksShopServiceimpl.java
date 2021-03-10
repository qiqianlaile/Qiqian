package com.qf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.client.booksclient;
import com.qf.pojo.BaseResp;
import com.qf.pojo.user.books;
import com.qf.pojo.user.user;
import com.qf.service.booksShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class booksShopServiceimpl implements booksShopService {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    booksclient booksclient;

    @Override
    public BaseResp addbooks(Integer bid, HttpServletRequest request) {
        //获取到当前的用户
        user user = findbookstoken(request);
        //获取书的信息
        books books1 = booksclient.findbyid(bid);
        //声明返回值
        BaseResp baseResp=new BaseResp();

        try {
            //操作Redis
            redisTemplate.opsForHash().put("books_"+user.getId().toString(),bid.toString(),books1);
        } catch (Exception e) {

            baseResp.setMessage("添加失败");
               return baseResp;

        }
        baseResp.setMessage("添加成功");
        return baseResp;
    }

    @Override
    public BaseResp finduserbooks(HttpServletRequest request) {
        user userToken = findbookstoken(request);
        if(redisTemplate.hasKey("books_"+userToken.getId())){
            List list = redisTemplate.opsForHash().values("books_" + userToken.getId());
            BaseResp baseResp = new BaseResp();
            baseResp.setList(list);
            return baseResp;
        }
        return null;
    }

    @Override
    public BaseResp deletebook(Integer bid, HttpServletRequest request) {
        //获取当前用户ID
        user user = findbookstoken(request);
        BaseResp baseResp = new BaseResp();
        try {
            //操作Redis删除书架
//            Object o = redisTemplate.opsForHash().get("books_"+user.getId(), bid);
            redisTemplate.opsForHash().delete("books_"+user.getId().toString(),bid.toString());
        } catch (Exception e) {
            baseResp.setMessage("移出书架失败");
            return baseResp;
        }
        baseResp.setMessage("移出书架成功");
        return baseResp;
    }

    public user findbookstoken(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String token = getToken(cookies);
        Object o = redisTemplate.opsForValue().get(token);
        Object o1 = JSONObject.toJSON(o);
        user user = JSONObject.parseObject(o1.toString(), user.class);
        return user;

    }

    public String getToken(Cookie [] cookies){
        if (cookies!=null){
            for (Cookie cook:cookies
            ) {
                if (cook.getName().equals("token")){
                    String token = cook.getValue();
                    return token;
                }
            }
            return null;
        }
        return null;
    }
}
