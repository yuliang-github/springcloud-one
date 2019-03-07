package com.yl.api.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Alex
 * @since 2019/3/7 13:45
 */
// 此处必须添加该注解,加入Spring容器中
@Component
public class DeptFallbackFactory implements FallbackFactory<DeptFeignApi> {

    @Override
    public DeptFeignApi create(Throwable throwable) {
        return new DeptFeignApi() {
            @Override
            public String get(int id) {
                return "熔断提示:出现错误,请联系客服哦!错误信息:" + throwable.getMessage();
            }
        };
    }
}
