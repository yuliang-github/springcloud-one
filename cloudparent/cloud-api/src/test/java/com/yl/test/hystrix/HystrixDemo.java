package com.yl.test.hystrix;

import java.lang.reflect.Method;

/**
 * @author Alex
 * @since 2019/3/7 16:32
 */
public class HystrixDemo {

    public static void main(String[] args) throws Exception{

        String s = "get";

        HystrixFallback fallback = new HystrixFallback();

        Inter inter = fallback.create(new RuntimeException("get方法出现异常"));

        Class<? extends Inter> interClass = inter.getClass();

        Method method = interClass.getMethod(s, String.class);

        System.err.println(method.invoke(inter,new Object[]{"北京城"}));
    }

}




