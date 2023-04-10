package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        /*Tenant xiaoming = new Tenant();
        RoomAgency roomAgency = new RoomAgency(xiaoming);
        roomAgency.seekRoom();
        roomAgency.watchRoom();
        roomAgency.room();
        roomAgency.finish();*/

        // 1.静态代理的缺点
        // 如果小明想买房，而不是租房，房产中介不能满足小明的需求
        // 因为这个中介只有替人租房的能力，此时需要更换租房接口为买房接口，再定义一个买房的房产中介
        // 这就是静态代理的缺点，只能为给定接口下的实现类做代理，接口不同则需要定义不同的代理类
        // 系统复杂度增加，则很难维护这么多代理类和被代理类之间的关系
        // 当需要频繁更换接口，更换类时，采用动态代理
        // 动态代理可以只通过一个代理类来代理N多个被代理类，它在更换接口时，不需要重新定义代理类
        // 因为动态代理不需要根据接口提前定义代理类，它把代理类的创建推迟到代码运行时来完成

        // 2.静态代理 动态代理的区别
        // class加载：编写的java文件通过javac编译后，生成.class文件，代码运行前，jvm会读取class文件，解析文件里面的信息，取出二进制数据
        // 加载到内存中，从而形成对应的Class对象
        // 静态代理在程序前就创建好RoomAgency.class，而动态代理则相反，在运行代码前不存在代理类的.class文件，运行时才生成代理类

        // 构造一个租客
        IRoom xiaoming = new Tenant();
        // 构造一个动态代理
        InvocationHandler dynamicProxy = new DynamicProxy(xiaoming);
        // 获取被代理类租客的classLoader
        ClassLoader classLoader = xiaoming.getClass().getClassLoader();
        // 1.通过Proxy类的newProxyInstance方法动态构造一个代理人房产中介
        IRoom roomAgency = (IRoom) Proxy.newProxyInstance(classLoader,new Class[]{IRoom.class},dynamicProxy);
        // 调用代理对象的方法
        roomAgency.seekRoom();
        roomAgency.watchRoom();
        roomAgency.room();
        roomAgency.watchRoom();


    }
}
