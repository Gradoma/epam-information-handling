package by.epamtraining.iht.parser;

import by.epamtraining.iht.composite.Component;
import by.epamtraining.iht.composite.impl.TextComposite;
import by.epamtraining.iht.exception.UnhandledOperationException;

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
    public Component parse(String stringForParsing) {
        //
        Component sentenceComponent = new TextComposite();
        Matcher matcher = LEXEM.matcher(stringForParsing);
        List<String> lexemList = new ArrayList<>();
        while (matcher.find()){
            lexemList.add(matcher.group());
        }
        Component childComponent;
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
