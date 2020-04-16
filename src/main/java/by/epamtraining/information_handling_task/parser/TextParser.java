package by.epamtraining.information_handling_task.parser;

public class TextParser extends AbstractParser {
    AbstractParser nextParser = super.nextParser;

    @Override
    public boolean parse(String stringForParsing) {
        // parsing to parag
        String s = stringForParsing + " text ";
        System.out.println(s);
        return super.parseNext(s);
    }
}
