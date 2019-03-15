package com.yl.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Alex
 * @since 2019/3/8 10:39
 */
public class DateDemo {

    public static void main(String[] args) throws Exception{

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        int[] ymd = getYMD(df.parse("2018-03-12"), new Date());

        System.err.println("年:" + ymd[0] + ",月:" + ymd[1] + ",日" + ymd[2]);

    }


    public static int[] getYMD(Date begin,Date end) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(begin);

        int year_begin = calendar.get(Calendar.YEAR);
        int month_begin = calendar.get(Calendar.MONTH);
        int day_begin = calendar.get(Calendar.DAY_OF_MONTH);

        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.setTime(end);
        int year_end = calendar.get(Calendar.YEAR);
        int month_end = calendar.get(Calendar.MONTH);
        int day_end = calendar.get(Calendar.DAY_OF_MONTH);

        int year = year_end - year_begin;
        int month = month_end - month_begin;
        int day = day_end - day_begin;

        if(day < 0) {
            day += maxDay;
            month -= 1;
        }
        if(month < 0) {
            month += 12;
            year -= 1;
        }
        return new int[] {year,month,day};
    }

    private static final ThreadLocal<DateFormat> LOCAL = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    @Test
    public void test(){
        DateFormat df = LOCAL.get();
        System.err.println(df.format(new Date()));
    }
}
