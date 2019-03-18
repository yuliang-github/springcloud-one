package com.yl.springcloud;

import com.netflix.loadbalancer.IRule;
import com.yl.springcloud.config.CustomerLoadRule;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @author Alex
 * @since 2019/3/15 14:52
 */
@Configuration
@EnableZuulProxy
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
//@EnableRetry
public class MainConfig {

    /**
     * 1.Zuul的跨域问题
     *  1.1 @{@link org.springframework.web.bind.annotation.CrossOrigin}
     *  1.2 {@link org.springframework.web.filter.CorsFilter}
     *  1.3 拓展资料:慕课网免费课程: Ajax跨域完全讲解
     *
     * 2.Zuul重试设置
     *  1.@EnableRetry
     *  2.      <dependency>
     *             <groupId>org.springframework.retry</groupId>
     *             <artifactId>spring-retry</artifactId>
     *         </dependency>
     *  3.loadbalancer:
     *       retry:
     *         enabled: true 开启负载均衡器重试开关
     *  4.zuul:
     *      retryable: true 开启Zuul自动重试开关
     *
     */
    @Bean
    public CorsFilter corsFilter(){
        CorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setMaxAge(300L);
        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }



    /**
     * zuul的底层也是使用Ribbon来进行服务调用的
     * 所以也可以自定义负载均衡策略
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule iRule(){
//        return new CustomerLoadRule();
//    }


}
