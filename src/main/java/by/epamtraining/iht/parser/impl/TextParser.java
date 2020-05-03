package by.epamtraining.iht.parser.impl;

import by.epamtraining.iht.entity.TextComponent;
import by.epamtraining.iht.entity.impl.ComponentType;
import by.epamtraining.iht.entity.impl.TextComposite;
import by.epamtraining.iht.exception.IncorrectParserStructureException;
import by.epamtraining.iht.exception.UnhandledOperationException;
import by.epamtraining.iht.parser.AbstractParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();
    private static final Pattern PARAGRAPH = Pattern.compile("(\\s{4}.+?)(\\s{4}|$)");

    public TextParser(){
        super(new ParagraphParser());
    }

    @Override
    public TextComponent parse(String stringForParsing) throws IncorrectParserStructureException{
        logger.info("parameter: String: " + stringForParsing);
        TextComponent textComponent = new TextComposite(ComponentType.TEXT);
        Matcher matcher = PARAGRAPH.matcher(stringForParsing);
        TextComponent childComponent;
        int indexEnd = 0;
        while (matcher.find(indexEnd)){
            int indexStart = matcher.start(1);
            indexEnd = matcher.start(2);
            String paragraph = stringForParsing.substring(indexStart, indexEnd);
            logger.info("match: paragraph: " + paragraph);
            childComponent = parseNext(paragraph);
            try{
                textComponent.add(childComponent);
            } catch (UnhandledOperationException e){
                logger.error("incorrect chain structure");
                throw new IncorrectParserStructureException(e);
            }
        }

//        for (String parag : paragraphArray){
//            childComponent = parseNext(parag);
//            try{
//                textComponent.add(childComponent);
//            } catch (UnhandledOperationException e){
//                System.out.println("incorrect chain structure");
//            }
//
//        }
        logger.info("result TextComponent: " + textComponent);
        return textComponent;
    }
}
