package com.proxy.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {
    //真实对象
    private Object target;
    //拦截器全限定名
    private String interceptorClass = null;

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 绑定委托对象并返回一个【代理占位】
     *
     * @param target           真实对象
     * @param interceptorClass 拦截器全限定名
     * @return 代理对象【占位】
     */
    public static Object bind(Object target, String interceptorClass) {
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target, interceptorClass));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            return method.invoke(target, args);
        }

        Object result = null;
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();

        if (interceptor.before(proxy, target, method, args)) {
            //反射原有对象方法
            //如果befor返回的是true，进来了 around方法就无法执行，打印出helloworld
            result = method.invoke(target, args);
        } else {
            //返回false执行around方法
            interceptor.around(proxy, target, method, args);
        }

        interceptor.after(proxy, target, method, args);
        return result;
    }
}
