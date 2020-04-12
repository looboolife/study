package com.shengsiyuan.classloader;

/**
 * @author liubo
 * @date 2019/11/18
 * 对于静态字段来说,只有直接定义了该字段的类才会初始化
 * 当一个类在初始化时,要求其父类全部都已经初始化完毕了
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 *
 * -XX:+<option> ,表示开启option选项
 * -XX:-<option>,表示关闭option选项
 * -XX:<option>=<value>,表示将option选项的值设置为value
 *
 */
public class MyTest1 {
    public static void main(String[] args) {
        /*
         * 结果:
         * MyParent1 static block
         * MyParent1 str
         */
//        System.out.println(MyChild1.str);
        /*
         * 结果:
         * MyParent1 static block
         * MyChild1 static block
         * MyChild1 str
         */
        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "MyParent1 str";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "MyChild1 str";

    static {
        System.out.println("MyChild1 static block");
    }
}
