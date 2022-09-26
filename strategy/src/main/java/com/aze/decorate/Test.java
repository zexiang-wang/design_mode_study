package com.aze.decorate;

public class Test {
    public static void main(String[] args) {
        ConcreteCompent c = new ConcreteCompent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.operation();


    }
}
