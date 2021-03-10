package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//标注当前是config服务端
@EnableConfigServer
public class baolemoconfigApplication {
    public static void main(String[] args) {
        System.out.println("8100");
        SpringApplication.run(baolemoconfigApplication.class);

    }
}
