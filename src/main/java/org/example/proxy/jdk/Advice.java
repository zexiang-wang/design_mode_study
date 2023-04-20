package org.example.proxy.jdk;

public class Advice {
    public void before(){
        System.out.println("--核心之前增强--");
    }
    public void after(){
        System.out.println("--核心之后增强--");
    }
}
