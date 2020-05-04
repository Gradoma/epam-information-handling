package by.epamtraining.iht.action;

import by.epamtraining.iht.entity.TextComponent;
import by.epamtraining.iht.exception.UnhandledOperationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TextAction {
    private static Logger logger = LogManager.getLogger();

    public void sortParagBySentences(TextComponent component) throws UnhandledOperationException {
        logger.info("parameter: TextComponent: " + component);
        Comparator comparator = new ParagSizeComparator();
        component.getChildComponents().sort(comparator);
    }

    public String findSentenceWithLongestWord(TextComponent component) throws UnhandledOperationException {
        logger.info("parameter: TextComponent: " + component);
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
                        logger.info("new max word length = " + maxLength);
                        resultSentence = s.toString();
                    }
                }
            }
        }
        logger.info("result sentence: " + resultSentence);
        return resultSentence;
    }

    public void removeSentences(TextComponent component, int lexemCounter) throws UnhandledOperationException {
        logger.info("parameter: TextComponent: " + component);
        List<TextComponent> parag = component.getChildComponents();
        for (TextComponent par : parag) {
            List<TextComponent> sentenceList = par.getChildComponents();
            for (Iterator<TextComponent> iterator = sentenceList.iterator(); iterator.hasNext(); ) {
                TextComponent sentence = iterator.next();
                if (sentence.getChildComponents().size() < lexemCounter) {
                    logger.info("sentence for removing: " + sentence);
                    iterator.remove();
                }
            }
        }
    }

    public Map<String, Integer> findIdenticalLexems(TextComponent component) throws UnhandledOperationException {
        logger.info("parameter: TextComponent: " + component);
        List<String> operationList = new ArrayList<>();
        Map<String, Integer> identicalWordsCounter = new HashMap<>();
        List<TextComponent> parag = component.getChildComponents();
        for (TextComponent par : parag) {
            List<TextComponent> sent = par.getChildComponents();
            for (TextComponent s : sent) {
                List<TextComponent> lexemList = s.getChildComponents();
                for (TextComponent l : lexemList) {
                    String word = l.toString().strip().toUpperCase();
                    if (!word.isEmpty()) {
                        operationList.add(word);
                    }
                }
            }
        }
        for (int i = 0; i < operationList.size() - 1; i++) {
            String checkWord = operationList.get(i);
            logger.info("check word: " + checkWord);
            for (Iterator<String> iterator = operationList.listIterator(i + 1); iterator.hasNext(); ) {
                String nextWord = iterator.next();
                if (checkWord.equals(nextWord)) {
                    if (!identicalWordsCounter.containsKey(checkWord)) {
                        identicalWordsCounter.put(checkWord, 2);
                        logger.info("match: word added to result Map");
                    } else {
                        identicalWordsCounter.put(checkWord, identicalWordsCounter.get(checkWord) + 1);
                        logger.info("match: word already contains in result Map; value increased");
                    }
                }
            }
        }
        logger.info("result Map: " + identicalWordsCounter);
        return identicalWordsCounter;
    }
}
