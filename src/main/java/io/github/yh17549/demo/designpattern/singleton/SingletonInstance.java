package io.github.yh17549.demo.designpattern.singleton;

/**
 * @author xyh
 * @date 2018-11-08
 */
public class SingletonInstance {}

/**
 * 饿汉式
 * 多线程不会出问题
 * 有可能造成资源浪费
 */
class SingletonInstance01 {

    private static SingletonInstance01 instance = new SingletonInstance01();

    private SingletonInstance01(){}

    public static SingletonInstance01 getInstance(){
        return instance;
    }

}

/**
 * 懒汉式
 * 多线程会出问题
 */
class SingletonInstance02 {

    private static SingletonInstance02 instance = null;

    private SingletonInstance02(){}

    public static SingletonInstance02 getInstance(){
        // 当两个线程同时运行到此处时，instance 为空时，两个线程都会创建一个实例
        if(instance == null){
            instance = new SingletonInstance02();
        }
        return instance;
    }

}

/**
 * 懒汉式
 */
class Singletoninstance03 {

    private static Singletoninstance03 instance = null;

    private Singletoninstance03(){}

    public static synchronized Singletoninstance03 getinstance(){
        if(instance == null){
            instance = new Singletoninstance03();
        }
        return instance;
    }
}

/**
 * 懒汉式
 */
class SingletonInstance04 {

    private static SingletonInstance04 instance = null;

    private SingletonInstance04() {}

    public static SingletonInstance04 getInstance() {
        // 为什么要 double check
        // 1. 如果少了 (1) 处的check ， 和 SingletonInstance03 无区别
        // 2. 如果少了 (3) 处的 check ,
        // 当两个线程同时运行到 (2) 处时，instance 为空时，两个线程都会创建一个实例

        // (1)
        if (instance == null) {
            // (2)
            synchronized (SingletonInstance04.class){
                // (3)
                if (instance == null){
                    instance = new SingletonInstance04();
                }
            }
        }
        return instance;
    }
}

/**
 * 懒汉式
 */
class SingletonInstance05 {

    private static class SingletonInstanceBuilder{
        private static SingletonInstance05 instance = new SingletonInstance05();
    }

    private SingletonInstance05(){}

    public static SingletonInstance05 getInstance(){
        return SingletonInstanceBuilder.instance;
    }
}

