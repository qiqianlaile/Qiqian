package com.qf.controller;

import com.qf.pojo.BaseResp;
import com.qf.pojo.user.books;
import com.qf.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bookcontroller {
    @Autowired
    bookService bookservice;
    //查询所有
    @RequestMapping("/findall")
    public BaseResp finAll(){
       return bookservice.findAll();

    }
    @RequestMapping("/findbyid")
    public books findbyid(@RequestParam("bid")Integer bid){
        return bookservice.findById(bid);
    }
}
