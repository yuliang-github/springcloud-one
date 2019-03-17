package com.yl.springcloud;

import com.yl.api.feign.DeptFallbackFactory;
import com.yl.other.config.RibbonConfig;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Alex
 * @since 2019/2/26 20:36
 */

@Configuration
@EnableFeignClients(basePackages = {"com.yl.api.feign"})
@RibbonClients(value = {
    @RibbonClient(name = "DEPT-PROVIDER",configuration = {RibbonConfig.class})
})
@ComponentScan("com.yl.api")
public class MainConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        ClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        ((SimpleClientHttpRequestFactory) factory).setConnectTimeout(2500);
        ((SimpleClientHttpRequestFactory) factory).setReadTimeout(5000);
        return new RestTemplate(factory);
    }

    /**
     * 关于Hystrix与Ribbon超时时间的配置
     *      1.配置Hystrix的超时:
     *          1.hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds: 10000
     *          2.hystrix.command.default.execution.timeout.enabled=false 关闭Hystrix的超时检查
     *      2.关于Ribbon的超时:
     *          1.ribbon:
     *              ConnectTimeout: 3000 请求连接超时
     *              ReadTimeout: 6000   请求响应超时
     *       注意:
     *          1.Hystrix的配置的超时时间要大于Ribbon的,不然在Ribbon返回之前,断路器就会进行熔断
     *          2.断路器的超时时间需要大于ribbon的超时时间，不然不会触发重试。
     *
     * 拓展:
     *      1.注意Ribbon的重试机制,默认首台重试一次
     *      2.关于Ribbon的重试机制,记一次bug
     *          我使用自定义的负载均衡策略,每个实例请求5次,会导致重试的时候继续重试失败的实例,而不会去重试其它实例。
     *
     * 关于Hystrix服务降级
     *  1.服务降级并不仅限于调用目标服务失败,程序内部发生异常也可触发服务降级
     *
     */


}
