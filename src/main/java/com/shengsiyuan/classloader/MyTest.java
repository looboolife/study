package com.shengsiyuan.classloader;

import java.sql.Timestamp;

/**
 * @author liubo
 * @date 2019/11/25
 */
public class MyTest {
    public static void main(String[] args) throws Exception{
        double total = 0;
        for (int i = 0; i < 6; i++) {
            total += 12;
            System.out.println(total);
            total *= 1.12;
            System.out.println(total);
        }
        System.out.println(total);

        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}
