package by.epamtraining.iht.action;

import by.epamtraining.iht.entity.impl.TextComposite;

import java.util.Comparator;

public class ParagSizeComparator implements Comparator<TextComposite> {

    @Override
    public int compare(TextComposite o1, TextComposite o2) {
        int size1 = o1.getChildComponents().size();
        int size2 = o2.getChildComponents().size();
        return Integer.compare(size1, size2);
    }
}
