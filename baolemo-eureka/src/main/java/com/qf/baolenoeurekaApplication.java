package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//标注工程为eureka服务端
@EnableEurekaServer
public class baolenoeurekaApplication {
    public static void main(String[] args) {
        System.out.println("8080启动了");
        SpringApplication.run(baolenoeurekaApplication.class);

    }
}
