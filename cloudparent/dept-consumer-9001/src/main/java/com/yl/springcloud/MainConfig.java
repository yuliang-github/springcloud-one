package com.yl.springcloud;

import com.yl.other.config.RibbonConfig;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Alex
 * @since 2019/2/26 20:36
 */

/**
 * 根据微服务自定义负载均衡策略
 *      自定义IRule
 *          1.继承AbstractLoadBalancerRule自定义负载均衡策略
 *          2.实例在配置类中生成
 *                              微服务名                        负载均衡策略配置类
 *      1.@RibbonClient(name = "DEPT-PROVIDER",configuration = RibbonConfig.class)
 *      注意事项:
 *          1.RibbonConfig类不能放在BasePackage包下,不然会使所有微服务只用改策略
 *          2.RibbonConfig必须使用@Configuration注解,不然配置不能生效
 */
@RibbonClients(
    @RibbonClient(name = "DEPT-PROVIDER",configuration = RibbonConfig.class)
)
@Configuration
public class MainConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
