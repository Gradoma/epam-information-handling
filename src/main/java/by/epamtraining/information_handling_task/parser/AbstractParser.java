package by.epamtraining.information_handling_task.parser;

public abstract class AbstractParser {
    protected AbstractParser nextParser;


    public abstract boolean parse(String stringForParsing);

    protected boolean parseNext(String stringForParsing){
        System.out.println("we are in abstract");
        if(nextParser == null){
            return false;
        }
        return nextParser.parse(stringForParsing);
    }
}
