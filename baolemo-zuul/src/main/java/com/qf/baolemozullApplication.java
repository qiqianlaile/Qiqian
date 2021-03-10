package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
//使能zuul
@EnableZuulProxy
@EnableConfigurationProperties
public class baolemozullApplication {
    public static void main(String[] args) {
        System.out.println("9000");
        SpringApplication.run(baolemozullApplication.class);

    }

}

