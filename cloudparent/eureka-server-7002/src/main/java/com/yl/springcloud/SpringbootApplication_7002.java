package com.yl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Alex
 * @since 2019/2/26 12:57
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringbootApplication_7002 {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootApplication_7002.class,args);

    }

}
