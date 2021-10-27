package com.sherlock.data_structure;

public class SingleInstance {
    private static volatile SingleInstance singleInstance = null;//volatile 防止指令重排

    private SingleInstance() {

    }

    public static SingleInstance getInstance() {
        if (singleInstance == null) {
            synchronized (SingleInstance.class) {
                if (singleInstance == null) {
                    singleInstance = new SingleInstance();
                }
            }
        }
        return singleInstance;
    }
}
