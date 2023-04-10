package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
        使用动态代理的基本步骤
     1、定义代理对象和真实对象的公共接口（与静态代理相同
     2、真实对象实现公共接口中的方法（与静态代理相同
     3、定义一个实现了InvocationHandle接口的动态代理类
     4、通过Proxy类的newProxyInstance方法创建代理对象，调用代理对象的方法
 */
public class DynamicProxy implements InvocationHandler {
    private Object mObject; //真实对象的引用

    public DynamicProxy(Object object){
        this.mObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 通过反射调用真实对象的方法
        Object result = method.invoke(mObject, args);
        return result;
    }

}
