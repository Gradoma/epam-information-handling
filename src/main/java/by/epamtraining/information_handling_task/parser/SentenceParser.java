package by.epamtraining.information_handling_task.parser;

public class SentenceParser extends AbstractParser {
    AbstractParser next = new LexemParser();

    @Override
    public boolean parse(String stringForParsing) {
        //
        String s = stringForParsing + " sent ";
        System.out.println(s);
        return parseNext(s);
    }
}
