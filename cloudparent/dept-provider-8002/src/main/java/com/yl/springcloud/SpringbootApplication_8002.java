package com.yl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Alex
 * @since 2019/2/26 13:41
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringbootApplication_8002 {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication_8002.class,args);
    }

}
