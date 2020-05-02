package by.epamtraining.iht.action;

import by.epamtraining.iht.composite.TextComponent;
import by.epamtraining.iht.composite.impl.TextComposite;
import by.epamtraining.iht.exception.UnhandledOperationException;

import java.util.*;

public class TextAction {

    public void sortParagBySentences(TextComponent component) throws UnhandledOperationException {
        Comparator comparator = new ParagSizeComparator();
        component.getChildComponents().sort(comparator);
    }

    public String findSentenceWithLongestWord(TextComponent component) throws UnhandledOperationException {
        int maxLength = -1;
        String resultSentence = null;
        List<TextComponent> parag = component.getChildComponents();
        for (TextComponent par : parag) {
            List<TextComponent> sent = par.getChildComponents();
            for (TextComponent s : sent) {
                List<TextComponent> lexemList = s.getChildComponents();
                for (TextComponent lex : lexemList) {
                    String lexemString = lex.toString();
                    if (lexemString.length() > maxLength) {
                        maxLength = lexemString.length();
                        resultSentence = s.toString();
                    }
                }

            }
        }
        return resultSentence;
    }

    public void removeSentences(TextComponent component, int lexemCounter) throws UnhandledOperationException {
        List<TextComponent> parag = component.getChildComponents();
        for (TextComponent par : parag) {
            List<TextComponent> sentenceList = par.getChildComponents();
            for (Iterator<TextComponent> iterator = sentenceList.iterator(); iterator.hasNext(); ) {
                TextComponent sentence = iterator.next();
                if (sentence.getChildComponents().size() < lexemCounter) {
                    iterator.remove();
                }
            }
        }
    }

    public List<String> findIdenticalLexems(TextComponent component) throws UnhandledOperationException {
        List<String> operationList = new ArrayList<>();
        Map<String, Integer> identicalWordsCounter = new HashMap<>();
        List<TextComponent> parag = component.getChildComponents();
        for (TextComponent par : parag) {
            List<TextComponent> sent = par.getChildComponents();
            for (TextComponent s : sent) {
                List<TextComponent> lexemList = s.getChildComponents();
                for (TextComponent l : lexemList) {
                    String word = l.toString().strip();
                    if (!word.isEmpty()) {
                        operationList.add(word);
                    }
                }
            }
        }

        System.out.println("==before==" + operationList);
        for (int i = 0; i < operationList.size() - 1; i++) {
            String candidateWord = operationList.get(i);
            for (Iterator<String> iterator = operationList.listIterator(i + 1); iterator.hasNext(); ) {
                String nextWord = iterator.next();
                if (candidateWord.equalsIgnoreCase(nextWord)) {
                    if (!identicalWordsCounter.containsKey(candidateWord)) {
                        identicalWordsCounter.put(candidateWord, 2);
                    } else {
                        identicalWordsCounter.put(candidateWord, identicalWordsCounter.get(candidateWord) + 1);
                    }
                }
            }


//        Map<String, Integer> identicalWordsCounter = new HashMap<>();
//        for (String s : operationList){
//            System.out.println("template=" + s);
//            if (!identicalWordsCounter.containsKey(s)){
//                identicalWordsCounter.put(s, 1);
//            } else {
//                identicalWordsCounter.put(s, identicalWordsCounter.get(s) + 1);
//            }
//        }
//
//        boolean hasUniqWord = true;
//        while (hasUniqWord){
//            hasUniqWord = false;
//            for(){
//                if (identicalWordsCounter. == 1){
//
//                }
//            }
//            if (identicalWordsCounter.containsValue(1)){
//                hasUniqWord = true;
//                String uniqWord = identicalWordsCounter.
//            }
//        }
        }
        System.out.println(identicalWordsCounter);
        return operationList;
    }
}
