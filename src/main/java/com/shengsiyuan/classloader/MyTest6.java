package com.shengsiyuan.classloader;

/**
 * @author liubo
 * @date 2019/11/20
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("counter1: " + instance.counter1);
        System.out.println("counter2: " + instance.counter2);
    }

}

class Singleton {

    private static Singleton singleton = new Singleton();
    /**
     * 没有初始化,所以不变
     */
    public static int counter1;

    public Singleton() {
        counter1++;
        counter2++;
    }
    /**
     * 顺序位置不一样,值不一样
     * 准备阶段,从上到下执行,赋默认值,然后进行初始化
     */
    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
