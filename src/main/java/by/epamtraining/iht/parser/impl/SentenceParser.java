package by.epamtraining.iht.parser.impl;

import by.epamtraining.iht.entity.TextComponent;
import by.epamtraining.iht.entity.impl.ComponentType;
import by.epamtraining.iht.entity.impl.TextComposite;
import by.epamtraining.iht.exception.IncorrectParserStructureException;
import by.epamtraining.iht.exception.UnhandledOperationException;
import by.epamtraining.iht.parser.AbstractParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();
    private static final Pattern LEXEM = Pattern.compile(".+?(\\s|$)");

    public SentenceParser(){
        super(new LexemParser());
    }

    @Override
    public TextComponent parse(String stringForParsing) throws IncorrectParserStructureException {
        logger.info("parameter: String: " + stringForParsing);
        TextComponent sentenceComponent = new TextComposite(ComponentType.SENTENCE);
        Matcher matcher = LEXEM.matcher(stringForParsing);
        List<String> lexemList = new ArrayList<>();
        while (matcher.find()){
            logger.info("match: lexem: " + matcher.group());
            lexemList.add(matcher.group());
        }
        TextComponent childComponent;
        for (String lexem : lexemList){
            childComponent = super.parseNext(lexem);
            try{
                sentenceComponent.add(childComponent);
            } catch (UnhandledOperationException e){
                logger.error("incorrect chain structure");
                throw new IncorrectParserStructureException(e);
            }
        }
        logger.info("result TextComponent: " + sentenceComponent);
        return sentenceComponent;
    }
}
