package com.yl.test;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Alex
 * @since 2019/2/16 12:31
 */
public class spring {

    public static void main(String[] args) throws Exception {

        System.err.println("开始测试");

        File tempFile = File.createTempFile("temp-", ".txt");

        System.err.println(tempFile.getAbsolutePath());

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("删除文件");
                tempFile.deleteOnExit();
            }
        }));

        Thread.sleep(1000*60);

        System.exit(1);

    }

}
