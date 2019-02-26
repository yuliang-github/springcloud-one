package com.yl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Alex
 * @since 2019/2/26 12:50
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringcloudApplication_7001 {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudApplication_7001.class,args);
    }

}
