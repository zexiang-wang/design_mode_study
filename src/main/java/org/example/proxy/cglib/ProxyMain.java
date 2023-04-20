package org.example.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyMain {
    public static void main(String[] args) {
        Target target = new Target();
        Advice advice = new Advice();

        // 1.创建增强器
        Enhancer enhancer  = new Enhancer();
        // 2.设置增强目标类
        enhancer.setSuperclass(target.getClass());
        // 3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target,args);
                advice.after();
                return invoke;
            }
        });
        // 4.创建代理
        Target targetProxy = (Target) enhancer.create();
        targetProxy.coreWork();
    }
}
