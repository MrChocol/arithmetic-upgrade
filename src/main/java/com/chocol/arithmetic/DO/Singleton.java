package com.chocol.arithmetic.DO;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/12/3
 * @since
 */
public class Singleton {
    // volatile防止指令重排
    public static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                // 防止两个线程都进来了，配合volatile指令重排，强制刷新主内存
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
