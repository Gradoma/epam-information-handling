package by.epamtraining.iht.entity.impl;

import by.epamtraining.iht.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> childComponents = new ArrayList<>();
    private ComponentType type;

    public TextComposite(ComponentType type){
        this.type = type;
    }

    @Override
    public void add(TextComponent textComponent) {
        childComponents.add(textComponent);
    }

    public List<TextComponent> getChildComponents() {
        return childComponents;
    }

    public ComponentType getType(){
        return type;
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
        if(type != composite.type){
            return false;
        }
        if(childComponents == null){
            return composite.childComponents == null;
        }
        return childComponents.equals(composite.childComponents);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        if (childComponents != null){
            result = result + childComponents.hashCode();
        }
        return result;
    }
}
