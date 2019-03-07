package com.yl.api.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Alex
 * @since 2019/2/27 20:55
 */

/**
 * 配置熔断策略
 *  1.当调用的服务超时,或发生异常,则会进入熔断策略
 */
@FeignClient(value = "DEPT-PROVIDER",fallbackFactory = DeptFallbackFactory.class)
public interface DeptFeignApi {

    @GetMapping("/provider/dept/get")
    String get(@RequestParam("id") int id);



}
