package by.epamtraining.iht.action;

import by.epamtraining.iht.composite.TextComponent;
import by.epamtraining.iht.composite.impl.TextComposite;
import by.epamtraining.iht.exception.UnhandledOperationException;

import java.util.*;

public class TextAction {

    public void sortParagBySentences(TextComponent component) throws UnhandledOperationException{
        Comparator comparator = new ParagSizeComparator();
        component.getChildComponents().sort(comparator);
    }

    public String findSentenceWithLongestWord(TextComponent component) throws UnhandledOperationException{
        int maxLength = -1;
        String resultSentence = null;
        List<TextComponent> parag = component.getChildComponents();
        for(TextComponent par : parag){
            List<TextComponent> sent = par.getChildComponents();
            for(TextComponent s : sent){
                List<TextComponent> lexem = s.getChildComponents();
                for(TextComponent lex : lexem){
                    String lexemString = lex.toString();
                    if(lexemString.length() > maxLength){
                        maxLength = lexemString.length();
                        resultSentence = s.toString();
                    }
                }

            }
        }
        return resultSentence;
    }

    public void removeSentences(TextComponent component, int lexemCounter) throws UnhandledOperationException{
        List<TextComponent> parag = component.getChildComponents();
        for(TextComponent par : parag) {
            List<TextComponent> sentenceList = par.getChildComponents();
            for (Iterator<TextComponent> iterator = sentenceList.iterator(); iterator.hasNext();) {
                TextComponent sentence = iterator.next();
                if (sentence.getChildComponents().size() < lexemCounter) {
                    iterator.remove();
                }
            }
        }
    }

}
