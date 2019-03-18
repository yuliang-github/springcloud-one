package com.yl.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alex
 * @since 2019/3/18 17:12
 */
public class ExecutorDemo {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(10);

        es.submit(() -> System.err.println("正常的进来了"));

        es.shutdown();
        es.submit(() -> {
            System.err.println("shutdown之后进来了");
        });
    }

}
