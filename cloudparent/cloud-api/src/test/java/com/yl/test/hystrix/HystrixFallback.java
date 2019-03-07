package com.yl.test.hystrix;

/**
 * @author Alex
 * @since 2019/3/7 16:38
 */
public class HystrixFallback {

    public Inter create(Throwable t){
        return new Inter() {
            @Override
            public String get(String s) {
                return "错误{"+s+"}:" + t;
            }
        };
    }

}
