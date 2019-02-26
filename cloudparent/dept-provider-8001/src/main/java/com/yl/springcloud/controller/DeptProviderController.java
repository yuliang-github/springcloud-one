package com.yl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex
 * @since 2019/2/26 20:43
 */
@RestController
public class DeptProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/provider/dept/get")
    public String get(@RequestParam("id") int id){
        return "port:"+port+"给你应答,你好:" + id;
    }

}
