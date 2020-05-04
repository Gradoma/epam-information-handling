package by.epamtraining.iht.entity.impl;

import by.epamtraining.iht.entity.TextComponent;
import by.epamtraining.iht.exception.UnhandledOperationException;

import java.util.List;

public class Symbol implements TextComponent {
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
    public void add(TextComponent textComponent) throws UnhandledOperationException{
        throw new UnhandledOperationException("can't execute for this object");
    }

    @Override
    public List<TextComponent> getChildComponents() throws UnhandledOperationException{
        throw new UnhandledOperationException("can't execute for this object");
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null){
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Symbol symbol1 = (Symbol) o;

        return symbol == symbol1.symbol;
    }

    @Override
    public int hashCode() {
        return (int) symbol;
    }
}
