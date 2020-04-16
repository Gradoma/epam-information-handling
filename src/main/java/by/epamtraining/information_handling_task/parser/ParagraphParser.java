package by.epamtraining.information_handling_task.parser;

public class ParagraphParser extends AbstractParser {
    AbstractParser nextParser = new SentenceParser();


    @Override
    public boolean parse(String stringForParsing) {
        //
        String s = stringForParsing + " parag ";
        System.out.println(s);
        return parseNext(s);
    }
}
