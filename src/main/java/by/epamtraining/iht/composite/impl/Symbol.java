package by.epamtraining.iht.composite.impl;

import by.epamtraining.iht.composite.Component;
import by.epamtraining.iht.exception.UnhandledOperationException;

public class Symbol implements Component{
    private char symbol;

    public Symbol(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(Component component) throws UnhandledOperationException{
        throw new UnhandledOperationException("can't execute for this object");
    }
}
