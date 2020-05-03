package by.epamtraining.iht.parser.impl;

import by.epamtraining.iht.composite.TextComponent;
import by.epamtraining.iht.composite.impl.ComponentType;
import by.epamtraining.iht.composite.impl.TextComposite;
import by.epamtraining.iht.exception.UnhandledOperationException;
import by.epamtraining.iht.parser.AbstractParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final Pattern SENTENCE = Pattern.compile(".+?[.?!…](\\s|$)");

    public ParagraphParser() {
        super(new SentenceParser());
    }

    @Override
    public TextComponent parse(String stringForParsing) {
        //
        List<String> sentenceList = new ArrayList<>();
        Matcher matcher = SENTENCE.matcher(stringForParsing);
        while (matcher.find()) {
            sentenceList.add(matcher.group());
        }
        TextComponent paragraphComponent = new TextComposite(ComponentType.PARAGRAPH);
        TextComponent childComponent;
        for (String sentence : sentenceList){
            childComponent = super.parseNext(sentence);         // SUPER WHY???
            try{
                paragraphComponent.add(childComponent);
            } catch (UnhandledOperationException e){
                System.out.println("incorrect chain structure");
            }
        }
        return paragraphComponent;
    }
}