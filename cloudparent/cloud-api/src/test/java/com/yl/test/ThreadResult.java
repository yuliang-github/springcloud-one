package com.yl.test;

/**
 * @author Alex
 * @since 2019/3/6 14:56
 */
public class ThreadResult<T> {

    private T t;

    public void set(T r){
        this.t = r;
    }

    public T get(){
        return  this.t;
    }

    @Override
    public String toString() {
        return "ThreadResult{" +
            "t=" + t +
            '}';
    }
}
