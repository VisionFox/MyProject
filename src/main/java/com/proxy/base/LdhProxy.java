package com.proxy.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LdhProxy {
    Ldh ldh = new Ldh();

    public Person getProxy() {
        return (Person) Proxy.newProxyInstance(LdhProxy.class.getClassLoader(),
                ldh.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")) {
                            System.out.println("proxy sing");
                            return method.invoke(ldh, args);
                        }

                        if (method.getName().equals("dance")) {
                            System.out.println("proxy dance");
                            return method.invoke(ldh, args);
                        }
                        return null;
                    }

                });
    }
}
