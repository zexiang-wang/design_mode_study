package org.example.proxy.jdk;

import org.example.proxy.cglib.Advice;
import org.example.proxy.cglib.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyMain {
    public static void main(String[] args) {
        Target target = new Target();
        Advice advice = new Advice();
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();
                        Object invoke = method.invoke(target, args);
                        advice.after();
                        return invoke;
                    }
                }
        );
        proxy.coreWork();
    }
}
