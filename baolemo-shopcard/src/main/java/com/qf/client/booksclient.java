package com.qf.client;

import com.qf.pojo.user.books;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(serviceId = "baoleme-shop")
public interface booksclient {
    @RequestMapping("/findbyid")
    public books findbyid(@RequestParam("bid")Integer bid);
}
