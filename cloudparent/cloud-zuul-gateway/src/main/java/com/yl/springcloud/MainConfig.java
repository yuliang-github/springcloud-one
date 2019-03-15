package com.yl.springcloud;

import com.netflix.loadbalancer.IRule;
import com.yl.psringcloud.config.CustomerLoadRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Alex
 * @since 2019/3/15 14:52
 */
@Configuration
@EnableZuulProxy
@EnableEurekaClient
public class MainConfig {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule iRule(){
        return new CustomerLoadRule();
    }
}
