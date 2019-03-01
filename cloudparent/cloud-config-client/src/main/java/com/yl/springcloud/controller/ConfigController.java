package com.yl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex
 * @since 2019/2/28 21:11
 */
@RestController
public class ConfigController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/getConfig")
    public String getConfig(@RequestParam("config") String config){
        Environment environment = context.getEnvironment();
        return environment.getProperty(config);
    }

}
