package org.example.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;

public class ProxyTest implements Serializable {
    protected InvocationHandler h;
    /**
        Proxy这个类的作用就是用来动态地创建一个代理对象
        它内部持有一个InvocationHandler引用，在构造器中传入，它公开了getProxyClass方法和newProxyInstance方法

     . getProxyClass(重点方法)
         这个方法的作用时在运行时，根据.class的结构生成一个代理Class二进制流，
         该代理Class对象继承Proxy并实现了传入的第二个参数对应的Interface列表
     . newProxyInstance(常使用的方法)
         这个方法的作用是在运行时根据代理Class对象生成代理对象实例
         这个方法中，会先调用getProxyClass方法生成代理Class对象
         在获取到代理Class对象后，通过反射创建代理对象实例并在构造器中传入InvocationHandle实例
         所以newProxyInstance最终结果是生成一个代理对象实例
         该代理对象会继承Proxy类并实现给定的接口列表，同时内部持有一个InvocationHandle的引用
     */

    protected ProxyTest(InvocationHandler h){
        this.h = h;
    }
    // 根据指定的类加载器和接口来获取代理对象的class对象
    public static Class<?> getProxyClass(ClassLoader classLoader,Class... interfaces) throws IllegalArgumentException{
        return null;
    }
    // 根据指定的类加载器和接口生成代理对象
    public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)throws IllegalArgumentException{
        return null;
    }
}
