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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : childComponents){
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
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
        TextComposite composite = (TextComposite) o;
        if(childComponents == null){
            return composite.childComponents == null;
        }
        return childComponents.equals(composite.childComponents);
    }

    @Override
    public int hashCode() {
        if (childComponents != null){
            return childComponents.hashCode();
        }
        return 0;
    }
}
