package by.epamtraining.information_handling_task.parser;

public class SentenceParser extends AbstractParser {

    public SentenceParser(){
        super(new LexemParser());
    }

    @Override
    public void parse(String stringForParsing) {
        //
        String s = stringForParsing + " sent ";
        System.out.println(s);
        parseNext(s);
    }
}
