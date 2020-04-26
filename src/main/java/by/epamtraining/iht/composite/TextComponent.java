package by.epamtraining.iht.composite;

import by.epamtraining.iht.exception.UnhandledOperationException;

public interface TextComponent {
    void add(TextComponent textComponent) throws UnhandledOperationException;
    String toString();
}
