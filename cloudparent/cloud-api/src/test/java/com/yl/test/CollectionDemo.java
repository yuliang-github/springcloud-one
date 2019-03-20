package com.yl.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex
 * @since 2019/3/19 12:02
 */
public class CollectionDemo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        List<Integer> newList = new LinkedList<>();
    }

}
