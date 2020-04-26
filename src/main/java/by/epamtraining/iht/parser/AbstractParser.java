package by.epamtraining.iht.parser;

import by.epamtraining.iht.composite.TextComponent;
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

//    public abstract boolean parse(String stringForParsing);

//    protected boolean parseNext(String stringForParsing){
//        logger.info("parameter: String: " + stringForParsing);
//        if(nextParser == null){
//            logger.info("next Parser is null, end of chain");
//            return false;
//        }
//        logger.info("next parser: " + nextParser.getClass().getName());
//        return nextParser.parse(stringForParsing);
//    }

    public abstract TextComponent parse(String stringForParsing);

    protected TextComponent parseNext(String stringForParsing){
//        logger.info("parameter: String: " + stringForParsing);
        if(nextParser == null){
            logger.info("next parser: null" );
            return null;
        }
        return nextParser.parse(stringForParsing);
    }
}
