package by.epamtraining.iht.composite.impl;

import by.epamtraining.iht.composite.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> childComponents = new ArrayList<>();

    @Override
    public void add(TextComponent textComponent) {
        childComponents.add(textComponent);
    }

    public List<TextComponent> getChildComponents() {
//        return new ArrayList<>(childComponents);
        return childComponents;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : childComponents){
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
