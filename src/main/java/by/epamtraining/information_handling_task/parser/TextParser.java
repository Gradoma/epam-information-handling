package by.epamtraining.information_handling_task.parser;

import java.util.Arrays;
import java.util.List;

public class TextParser extends AbstractParser {
    private static final String DELIM = "   ";

    public TextParser(){
        super(new ParagraphParser());
    }

    @Override
    public void parse(String stringForParsing) {
        // parsing to parag
        String[] paragraphArray = stringForParsing.split(DELIM);
        List<String> paragraphList = Arrays.asList(paragraphArray);
        for (String parag : paragraphList){
            System.out.println("parag: " + parag);
            super.parseNext(parag);
        }
    }
}
