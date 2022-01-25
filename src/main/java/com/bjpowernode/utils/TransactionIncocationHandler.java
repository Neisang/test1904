package com.bjpowernode.utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionIncocationHandler implements InvocationHandler {

    private Object obj = null;

    public TransactionIncocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Object ie = null;

        try {
            ie = method.invoke(obj, args);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return ie;
    }


    public Object getProxy(Object obj){
      return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }


}
