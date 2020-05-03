package by.epamtraining.iht.composite.impl;

import by.epamtraining.iht.composite.TextComponent;
import by.epamtraining.iht.exception.UnhandledOperationException;

import java.util.List;

public class Symbol implements TextComponent {
    private char symbol;
    private final ComponentType type = ComponentType.SYMBOL;

    public Symbol(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public ComponentType getType() {
        return type;
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

        if (type != symbol1.type){
            return false;
        }
        return symbol == symbol1.symbol;
    }

    @Override
    public int hashCode() {
        int result = (int) symbol;
        result = 31 * result + type.hashCode();
        return result;
    }
}
