package by.epamtraining.iht.parser;

import by.epamtraining.iht.composite.Component;
import by.epamtraining.iht.composite.impl.TextComposite;
import by.epamtraining.iht.exception.UnhandledOperationException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final Pattern SENTENCE = Pattern.compile("\\s.+?[.?!…]");

    public ParagraphParser() {
        super(new SentenceParser());
    }

    @Override
    public Component parse(String stringForParsing) {
        //
        List<String> sentenceList = new ArrayList<>();
        Matcher matcher = SENTENCE.matcher(stringForParsing);
        while (matcher.find()) {
            sentenceList.add(matcher.group());
        }
        Component paragraphComponent = new TextComposite();
        Component childComponent;
        for (String sentence : sentenceList){
            childComponent = super.parseNext(sentence);
            try{
                paragraphComponent.add(childComponent);
            } catch (UnhandledOperationException e){
                System.out.println("incorrect chain structure");
            }
        }
        return paragraphComponent;
    }
}
