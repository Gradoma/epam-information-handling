package by.epamtraining.information_handling_task.parser;

import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final Pattern SENTENCE = Pattern.compile("\\.+[.?!…]");

    public ParagraphParser(){
        super(new SentenceParser());
    }


    @Override
    public void parse(String stringForParsing) {
        //
        String s = stringForParsing + " parag ";
        System.out.println(s);
        parseNext(s);
    }
}
