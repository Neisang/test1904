package com.bjpowernode.utils;

public class SqlService {

    public static Object getSqlService(Object obj){
        Object proxy = new TransactionIncocationHandler(obj).getProxy(obj);
        return proxy;
    }

}
