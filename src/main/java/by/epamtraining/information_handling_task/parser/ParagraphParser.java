package by.epamtraining.information_handling_task.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final Pattern SENTENCE = Pattern.compile("\\s.+?[.?!…]");

    public ParagraphParser(){
        super(new SentenceParser());
    }

    @Override
    public void parse(String stringForParsing) {
        //
        Matcher matcher = SENTENCE.matcher(stringForParsing);
        while (matcher.find()){
            System.out.println(matcher.group());
            parseNext(matcher.group());
        }
    }
}
