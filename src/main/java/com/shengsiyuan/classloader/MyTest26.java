package com.shengsiyuan.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author liubo
 * @date 2019/11/29
 *
 *
 * 线程上下文类加载器的一般使用模式(获取-使用-还原)
 * Classloader classloader = Thread.currentThread().getContextClassLoader();
 *
 * try{
 *     Thread.currentThread().setContextClassLoader(targetCl);
 *     myMethod();
 * }finally{
 *     Thread.currentThread().setContextClassLoader(classloader)
 * }
 *
 * myMethod里面调用了Thread.currentThread().getContextClassloader(),获取当前线程的上下文类加载器做某些事
 * 如果一个类由类加载器A加载,那么这种类的依赖类也是由相同的类加载器加载的(如果该依赖类之前没有被加载过的话)
 * ContextClassLoader的作用就是为了破坏Java的类加载委托机制
 * 当高层提供了统一的接口让低层去实现,同时又要在高层加载(或实例化)低层类时,就必须要通过线程上下文类加载器来帮助高层
 * 的ClassLoader找到并加载该类
 *
 */
public class MyTest26 {
    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()){
            Driver driver = iterator.next();
            Class<? extends Driver> aClass = driver.getClass();
            System.out.println(aClass + " ** 分割 ** " + aClass.getClassLoader());

        }
        System.out.println("Context ClassLoader: "+Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader ClassLoader: "+ServiceLoader.class.getClassLoader());

    }
}
