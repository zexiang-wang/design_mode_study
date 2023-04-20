package org.example.proxy.jdk;

public class Target implements TargetInterface{

    @Override
    public void coreWork() {
        System.out.println("--核心方法执行--");
    }
}
