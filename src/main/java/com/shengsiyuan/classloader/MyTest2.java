package com.shengsiyuan.classloader;

/**
 * @author liubo
 * @date 2019/11/19
 *
 * 常量在编译阶段会保存到调用这个常量的方法所在的类常量池中
 * 本质上,调用类并没有直接引用到定义常量类,因此并不会触发
 * 定义常量类的初始化
 * 注意:这里指的是将常量存放到MyTest2的常量池中,之后MyTest2与MyParent2就没有任何关系了
 * 甚至,我们可以将MyParent2的class文件删除
 *
 *反编译 :javap -c 全类名
 *
 * 助记符: 位于rt.jar里面的类
 * ldc表示将int,float或者是String类型的常量值从常量池中推送到栈顶
 * bipush 表示将单字节(-128 ~ 127)的常量推送至栈顶
 * sipush 表示将一个短整型常量值(-32768 ~ 32767)推送至栈顶
 * iconst_n表示将int类型n推送至栈顶(0<= n <=5,-1为m1)
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.n);
    }

}

class MyParent2 {
    public static final String str = "Hello World";
    public static final int n = -8;
    static {
        System.out.println("MyParent2 static block");
    }
}
