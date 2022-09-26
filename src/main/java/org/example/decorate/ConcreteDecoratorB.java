package org.example.decorate;

public class ConcreteDecoratorB extends Decorator{
    private String addedState;
    @Override
    public void operation(){
        super.operation();
        this.addedState = "new state";
        System.out.println("具体装饰对象B的操作");
    }
    private void AddedBehavior(){

    }
}
