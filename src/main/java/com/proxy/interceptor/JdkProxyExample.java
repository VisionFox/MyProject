package com.proxy.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {
    //真实对象
    private Object target = null;

    /**
     * 建立代理对象和真实对象的关系，并返回代理对象
     *
     * @param target 被代理的真实对象
     * @return 代理对象
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 代理方法的逻辑
     *
     * @param proxy  代理对象
     * @param method 当前调度的方法
     * @param args   当前方法的参数
     * @return 代理结果返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("准备调用真实对象的服务");
        Object obj = method.invoke(target, args);
        System.out.println("调用真实对象方法之后");
        return obj;
    }
}
