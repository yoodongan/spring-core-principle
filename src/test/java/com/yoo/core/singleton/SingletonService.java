package com.yoo.core.singleton;

public class SingletonService {
    private static final SingletonService singletonInstance;

    static{
        singletonInstance = new SingletonService();
    }

    public static SingletonService getSingletonInstance() {
        return singletonInstance;
    }

    private SingletonService() {

    }


}
