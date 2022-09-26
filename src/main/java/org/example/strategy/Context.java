package org.example.strategy;

public class Context {
    Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public void ContextInterface(){
        strategy.AlgorithmInterface();
    }
}
