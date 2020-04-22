package by.epamtraining.iht.composite;

import by.epamtraining.iht.exception.UnhandledOperationException;

public interface Component {
    void add(Component component) throws UnhandledOperationException;
    String toString();
}
