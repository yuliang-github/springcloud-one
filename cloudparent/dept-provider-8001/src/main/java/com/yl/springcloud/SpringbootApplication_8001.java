package com.yl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Alex
 * @since 2019/2/26 11:33
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringbootApplication_8001 {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication_8001.class,args);
    }

}
