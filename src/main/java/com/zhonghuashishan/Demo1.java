package com.zhonghuashishan;

import java.util.Date;

/**
 * @author liubo
 * @date 2020/3/16
 * -Xms 堆区内存初始内存分配的大小
 * -Xmx 堆区内存可被分配的最大上限
 * -XX:newSize：表示新生代初始内存的大小
 * -XX:MaxNewSize：表示新生代可被分配的内存的最大上限
 * -XX:PretenureSizeThreshold 大对象阈值
 * -XX:NewSize=5m -XX:MaxNewSize=5m -XX:InitialHeapSize=10m -XX:MaxHeapSize=10m
 * -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
 * <p>
 * -XX:+PrintGCDetails:打印详细的gc日志
 * -XX:+PrintGCTimeStamps:打印每次gc发生的时间
 * -Xloggc:gc.log:将gc日志写入一个磁盘文件
 *
 *
 *
 *
 *
 */
public class Demo1 {
    public static void main(String[] args) {
        //byte[] array1 = new byte[1024 * 1024];
        //array1 = new byte[1024 * 1024];
        //array1 = new byte[1024 * 1024];
        //array1 = null;
        //byte[] array2 = new byte[2 * 1024 * 1024];
        System.out.println(new Date());
    }
}
