package by.epamtraining.iht.composite.impl;

import by.epamtraining.iht.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private List<Component> childComponents = new ArrayList<>();

    @Override
    public void add(Component component) {
        childComponents.add(component);
    }
}
