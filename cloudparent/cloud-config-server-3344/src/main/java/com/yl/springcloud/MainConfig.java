package com.yl.springcloud;

import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alex
 * @since 2019/2/28 11:40
 */
@Configuration
@EnableEurekaClient
@EnableConfigServer
public class MainConfig {



}
