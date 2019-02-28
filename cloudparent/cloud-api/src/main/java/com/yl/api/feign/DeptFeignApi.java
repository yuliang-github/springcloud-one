package com.yl.api.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Alex
 * @since 2019/2/27 20:55
 */
@FeignClient(value = "DEPT-PROVIDER")
public interface DeptFeignApi {

    @GetMapping("/provider/dept/get")
    String get(@RequestParam("id") int id);



}
