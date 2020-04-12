package com.shengsiyuan.classloader;

/**
 * @author liubo
 * @date 2019/11/28
 *
 * 当前类加载器(Current Classloader)
 *
 * 每个类都会使用自己的类加载器(即加载自身的类加载器)去加载(所依赖的)其他类
 * 如果ClassX引用了ClassY,那么ClassX的类加载器就会去加载ClassY(前提是ClassY尚未被加载)
 *
 * 线程上下文加载器(Context Classloader)
 *
 * 线程上下文类加载器是从JDK1.2开始引用的,类Thread中的getContextClassloader()
 * 与setContextClassloader(Classloader cl)分别用来获取和设置上下文类加载器
 *
 * 如果没有通过setContextClassloader(Classloader cl)进行设置的话,线程将继承其父线程的上下文类加载器
 * Java应用运行时的初始线程的上下文类加载器是系统类加载器,在线程中运行的代码可以通过该类加载器来加载类与资源
 *
 * 线程上下文类加载器的重要性
 *
 * SPI (service provider interface)
 *
 * 父classloader可以使用当前线程Thread.currentThread().getContextClassloader
 * 所指定的classloader加载的类,这就改变了父classloader不能使用子classloader或
 * 是其他没有直接父子关系的classloader加载类的情况,即改变了双亲委托模型
 *
 * 线程上下文类加载器就是当前线程的Current Classloader
 *
 * 在双亲委托模型下,类加载器就是由下而上的,即下层的类加载器会委托上层进行加载,但是对于SPI来说,有些接口是
 * Java核心库所提供的,而Java核心库是由启动类加载器加载的,而这些接口的实现却来自于不同的jar包(厂商提供),
 * Java的启动类加载器是不会加载其他来源的jar包,这样传统的双亲委托模型就无法满足SPI的需求,而通过给当前
 * 线程设置上下文类加载器,就可以由设置的上下文类加载器来实现对于接口实现类的加载
 *
 *
 */
public class MyTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
