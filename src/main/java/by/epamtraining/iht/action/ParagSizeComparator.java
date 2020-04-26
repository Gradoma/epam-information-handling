package by.epamtraining.iht.action;

import by.epamtraining.iht.composite.impl.TextComposite;

import java.util.Comparator;

public class ParagSizeComparator implements Comparator<TextComposite> {

    @Override
    public int compare(TextComposite o1, TextComposite o2) {
        int size1 = o1.getChildComponents().size();
        int size2 = o2.getChildComponents().size();
//        System.out.println("size1=" + size1);
//        System.out.println(o1.toString());
//        System.out.println("size2=" + size2);
//        System.out.println(o2.toString());
        return Integer.compare(size1, size2);
    }
}
