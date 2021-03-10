package com.qf.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient(serviceId = "baoleme-shopcart")
public interface shopusercontrollerclient {
    @RequestMapping("/jisuanji")
    public String testcart();

}
