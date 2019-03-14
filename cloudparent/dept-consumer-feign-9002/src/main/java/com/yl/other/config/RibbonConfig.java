package com.yl.other.config;

import com.netflix.loadbalancer.IRule;
import com.yl.api.feign.DeptFallbackFactory;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alex
 * @since 2019/2/27 11:21
 */
@Configuration
public class RibbonConfig {


//    @Bean
//    public IRule myRule(){
//        return new CustomerLoadRule();
//    }

}
