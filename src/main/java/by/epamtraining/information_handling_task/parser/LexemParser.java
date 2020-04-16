package by.epamtraining.information_handling_task.parser;

public class LexemParser extends AbstractParser {
    AbstractParser next = null;

    @Override
    public boolean parse(String stringForParsing) {
        //
        String s = stringForParsing + " lexem ";
        System.out.println(s);
        return parseNext(s);
    }
}
