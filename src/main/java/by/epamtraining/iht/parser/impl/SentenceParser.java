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

public class SentenceParser extends AbstractParser {
    private static final Pattern LEXEM = Pattern.compile(".+?(\\s|$)");

    public SentenceParser(){
        super(new LexemParser());
    }

    @Override
    public TextComponent parse(String stringForParsing) {
        //
        TextComponent sentenceComponent = new TextComposite(ComponentType.SENTENCE);
        Matcher matcher = LEXEM.matcher(stringForParsing);
        List<String> lexemList = new ArrayList<>();
        while (matcher.find()){
            lexemList.add(matcher.group());
        }
        TextComponent childComponent;
        for (String lexem : lexemList){
            childComponent = super.parseNext(lexem);
            try{
                sentenceComponent.add(childComponent);
            } catch (UnhandledOperationException e){
                System.out.println("incorrect chain structure");
            }
        }
        return sentenceComponent;
    }
}
