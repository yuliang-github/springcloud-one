package com.yl.test;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Alex
 * @since 2019/3/6 13:37
 */
public class ThreadTest {

    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception{

        new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                   ThreadTest.demo("线程1");
               }catch (Exception e){

               }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ThreadTest.demo("线程2");
                }catch (Exception e){

                }
            }
        }).start();

        Thread.sleep(1000*60*5);
    }

    public static void demo(String s)throws Exception{
        System.err.println(s + ":开始获取锁");
        synchronized (lock){
            System.err.println(s + ":获取到了锁");
            try {
                // 次数会释放锁
                lock.notifyAll();
                lock.wait(60*1000);
            }catch (Exception e){
                System.err.println(e);
            }
            System.err.println(s + ":释放锁锁");
        }
    }

    @Test
    public void demo_1() throws Exception{
        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> future = es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });

        future.get();

    }

    @Test
    public void demo_2() throws Exception{
        ThreadResult<Integer> ret = new ThreadResult<>();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
               ret.set(100);
            }
        });

        t.start();
        t.join();

        System.err.println(ret);
    }
}
