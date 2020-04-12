package com.shengsiyuan.classloader;

import java.io.*;

/**
 * @author liubo
 * @date 2019/11/26
 */
public class MyTest16 extends ClassLoader {
    private String classLoaderName;

    private final String fileExtendName = ".class";

    /**
     * 父加载器为系统类加载器
     * @param classLoaderName
     */
    public MyTest16(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    /**
     * 指定类加载器
     * @param parent
     * @param classLoaderName
     */
    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "MyTest16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadClassData(name);

        return defineClass(name,bytes,0,bytes.length);
    }

    private byte[] loadClassData(String name) {
        byte[] data = null;
        try (
                InputStream is = new FileInputStream(new File(name + fileExtendName));
                ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ) {
            int ch = 0;
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }

            data = baos.toByteArray();
        } catch (Exception e) {

        }
        return data;
    }

    public static void main(String[] args) throws Exception{
        MyTest16 classLoader = new MyTest16("");
        Class<?> aClass = classLoader.loadClass("com.shengsiyuan.classloader.MyTest");
        Object o = aClass.newInstance();
        System.out.println(o);


    }
}
