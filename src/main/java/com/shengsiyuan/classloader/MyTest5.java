package com.shengsiyuan.classloader;

/**
 * @author liubo
 * @date 2019/11/20
 *
 * 当一个接口在初始化时,并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候(如引用接口中所定义的常量时)才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.a);
    }
}

interface MyParent5 {
    /**
     * public static final
     */
    Sout a = new Sout("MyParent5");

}

interface MyChild5 extends MyParent5{
    Sout b = new Sout("MyChild5");
}

class Sout{
    public Sout(String className) {
        System.out.println("Init " + className);
    }
}