package com.hongtu.test;


import java.sql.Timestamp;

import java.util.Calendar;
import java.util.Date;

public class Demo {
    public static void main(String[] args)  {
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(new Timestamp(System.currentTimeMillis()));

    }






}
