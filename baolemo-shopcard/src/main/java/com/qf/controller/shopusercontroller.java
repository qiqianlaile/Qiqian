package com.qf.controller;

import com.qf.pojo.BaseResp;
import com.qf.pojo.user.books;
import com.qf.service.booksShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class shopusercontroller {
    @Autowired
    booksShopService booksshopservice;

    @RequestMapping("/jisuanji")
    public String testcart(){
        return "我是吃的";
    }
    //添加书架
    @RequestMapping("/addbooks")
    public BaseResp addbook(@RequestBody Map map, HttpServletRequest request){

        return booksshopservice.addbooks((Integer)map.get("bid"),request);
    }

    //查看书架
    @RequestMapping("/finduserbooks")
    public BaseResp finduserbooks(HttpServletRequest request){
        return booksshopservice.finduserbooks(request);
    }
    //移出书架
    @RequestMapping("/deletebook")
    public BaseResp deledtebook(@RequestBody Map map, HttpServletRequest request){
        System.out.println((Integer)map.get("bid"));
        return booksshopservice.deletebook((Integer)map.get("bid"),request);
    }


}
