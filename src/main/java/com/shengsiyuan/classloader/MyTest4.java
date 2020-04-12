package com.shengsiyuan.classloader;

/**
 * @author liubo
 * @date 2019/11/19
 * 对于数组类型来说,其类型是JVM在运行期动态生成的,表示为 [Lcom.zhonghuashishan.shengsiyuan.classloader.MyParent4
 * 这种形式,动态生成的类型,其父类型就是Object
 * 对于数组来说,JavaDoc经常将构成数组的元素为Component,实际上就是将数组降低一个维度后的类型
 *
 * 助记符:
 *  anewarray: 表示创建一个引用类型的(如类,接口,数组)数组,并将其引用值压入栈顶
 *  newarray: 表示创建一个指定的原始类型(如int,float,char等)的数组,并将其引用值压入栈顶
 */
public class MyTest4 {
    public static void main(String[] args) {
        //MyParent4 myParent4 = new MyParent4();
        MyParent4[] array = new MyParent4[1];
        System.out.println(array.getClass());
        System.out.println(array.getClass().getSuperclass());
        MyParent4[][] array1 = new MyParent4[1][1];
        System.out.println(array1.getClass());
        System.out.println(array1.getClass().getSuperclass());
        System.out.println("--------------------------------------");
        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}
