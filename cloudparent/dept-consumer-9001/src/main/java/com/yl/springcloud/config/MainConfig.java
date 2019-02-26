package com.yl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Alex
 * @since 2019/2/26 20:36
 */
@Configuration
// 针对微服务自定义Ribbon的负载均衡策略
// 也可继承AbstractLoadBalancerRule自定义负载均衡策略,记住必须放在配置类中
// 该配置类不再BasePackage中,需要@Configuration
//@RibbonClients(value = {
//    @RibbonClient(name = "DEPT-PROVIDER",configuration = 配置类.class)
//})
public class MainConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
