package com.sugeladi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @PackageName: com.sugeladi
 * @ClassName: EurekaApplication
 * @Author: sushengchao
 * @Date: 2020/5/1 22:00
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer//开启
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}

