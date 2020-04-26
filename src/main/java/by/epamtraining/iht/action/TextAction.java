package by.epamtraining.iht.action;

import by.epamtraining.iht.composite.TextComponent;
import by.epamtraining.iht.composite.impl.TextComposite;

import java.util.Comparator;
import java.util.List;

public class TextAction {

    public void sortParagBySentences(TextComposite textComposite){
        Comparator comparator = new ParagSizeComparator();
        textComposite.getChildComponents().sort(comparator);
    }
}
