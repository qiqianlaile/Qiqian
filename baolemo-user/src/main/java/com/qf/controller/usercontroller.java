package com.qf.controller;

import com.qf.client.shopusercontrollerclient;
import com.qf.pojo.user.user;
import com.qf.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class usercontroller {
    @Autowired
    shopusercontrollerclient shopusercontrollerclient;
    @Autowired
    userservice userservice;


    @RequestMapping("/login")
    public String login(@RequestBody user user){
        return userservice.login(user);

    }


}
