package by.epamtraining.iht.parser;

import by.epamtraining.iht.entity.TextComponent;
import by.epamtraining.iht.exception.IncorrectParserStructureException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractParser {
    public AbstractParser nextParser;
    private static Logger logger = LogManager.getLogger();

    public AbstractParser(AbstractParser nextParser){
        this.nextParser = nextParser;
    }

    public AbstractParser getNextParser() {
        return nextParser;
    }

    public abstract TextComponent parse(String stringForParsing) throws IncorrectParserStructureException;

    protected TextComponent parseNext(String stringForParsing) throws IncorrectParserStructureException{
        if(nextParser == null){
            logger.info("next parser: null" );
            return null;
        }
        logger.info("next parser: " + nextParser.toString());
        return nextParser.parse(stringForParsing);
    }
}
