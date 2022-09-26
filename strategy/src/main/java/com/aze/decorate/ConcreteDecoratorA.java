package com.aze.decorate;

public class ConcreteDecoratorA extends Decorator{
    private String addedState;
    @Override
    public void operation(){
        super.operation();
        this.addedState = "new state";
        System.out.println("具体装饰对象A的操作");
    }
    
}
