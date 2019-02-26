package com.yl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Alex
 * @since 2019/2/26 20:38
 */
@RestController
public class DeptConsumer {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public static final String service_prefix = "http://DEPT-PROVIDER";

    @GetMapping("/consumer/dept/get")
    public String get(@RequestParam("id") int id){
        loadBalancerClient.choose("");
        return restTemplate.getForObject(service_prefix + "/provider/dept/get?id="+id, String.class);
    }

    /**
     * RestTemplate的三种使用方式
     *  1.写死url
     *  RestTemplate restTemplate = new RestTemplate();
     *  String service_prefix = "http://deptprovider8002.com:8002";
     *  restTemplate.getForObject(service_prefix + "/provider/dept/get,Object.class)
     *  2.通过负载均衡客户端获取一个服务提供者
     *         RestTemplate restTemplate = new RestTemplate();
     *         ServiceInstance provider = loadBalancerClient.choose("PROVIDER");
     *         String host = provider.getHost();
     *         int port = provider.getPort();
     *         String url = String.format("http://%s:%s",host.port);
     *         restTemplate.getForObject(url + "/provider/dept/get,Object.class)
     *  3.构建一个RestTemplate对象放在spring ioc容器中,利用@LoadBalanced来达到负载均衡的目的
     *     @Bean
     *     @LoadBalanced
     *     public RestTemplate restTemplate(){
     *         return new RestTemplate();
     *     }
     *     String service_prefix = "http://DEPT-PROVIDER";
     *     restTemplate.getForObject(service_prefix + "/provider/dept/get?id="+id, String.class);
     *
     */


    /**
     * Ribbon学习
     *  三大核心组件:
     *      1.ServerList:获取所有可用服务列表
     *      2.IRule:过滤之后剩余的地址中根据负载策略选择一个Server
     *      3.ServerListFilter:过滤一部分地址
     *
     */


}
