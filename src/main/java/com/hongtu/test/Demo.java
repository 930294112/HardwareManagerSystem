package com.hongtu.test;

import java.util.UUID;

public class Demo {
    public static void main(String[] args) {
        String id = UUID.randomUUID().toString();

        System.out.println(id.replaceAll("-",""));

        String sotr ="fa fa-sort-desc";
        System.out.println(sotr.contains("desc"));

        String str1 = "1,2,3,";
        System.out.println(str1.substring(0, str1.length() - 1));



    }


}
