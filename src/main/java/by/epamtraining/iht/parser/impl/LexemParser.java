package by.epamtraining.iht.parser.impl;

import by.epamtraining.iht.entity.TextComponent;
import by.epamtraining.iht.entity.impl.Symbol;
import by.epamtraining.iht.entity.impl.TextComposite;
import by.epamtraining.iht.exception.IncorrectParserStructureException;
import by.epamtraining.iht.exception.UnhandledOperationException;
import by.epamtraining.iht.parser.AbstractParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();

    public LexemParser(){
        super(null);
    }

    @Override
    public TextComponent parse(String stringForParsing) throws IncorrectParserStructureException {
        logger.info("parameter: String: " + stringForParsing);
        TextComponent lexemComponent = new TextComposite();
        char[] charArray = stringForParsing.toCharArray();
        TextComponent symbol;
        for (char c : charArray){
            symbol = new Symbol(c);
            logger.info("symbol: " + symbol);
            try{
                lexemComponent.add(symbol);
            } catch (UnhandledOperationException e){
                logger.error("incorrect chain structure");
                throw new IncorrectParserStructureException(e);
            }
        }
        logger.info("result TextComponent: " + lexemComponent);
        return lexemComponent;
    }
}
