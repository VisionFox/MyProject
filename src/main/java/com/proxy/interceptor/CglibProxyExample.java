package com.proxy.interceptor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyExample implements MethodInterceptor {

    /**
     * 生成CGLIB代理对象
     *
     * @param cls Class类
     * @return Class类的CGLIB代理对象
     */
    public Object getProxy(Class cls) {
        //CGLIB enhancer 增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //电影院代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor接口
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     *
     * @param proxy       代理对象
     * @param method      方法
     * @param args        方法参数
     * @param methodProxy 方法代理
     * @return 代理逻辑返回
     * @throws Throwable 异常
     */
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真实对象前");
        //CGLIB反射调用真实对象方法
        Object result = methodProxy.invokeSuper(proxy, args);
        System.out.println("调用真实对象后");
        return result;
    }
}
