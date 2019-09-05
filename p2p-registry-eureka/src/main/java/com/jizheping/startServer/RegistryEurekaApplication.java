package com.jizheping.startServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistryEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistryEurekaApplication.class,args);
    }
}
