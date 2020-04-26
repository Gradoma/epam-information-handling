package by.epamtraining.iht.parser;

import by.epamtraining.iht.composite.TextComponent;
import by.epamtraining.iht.composite.impl.TextComposite;
import by.epamtraining.iht.exception.UnhandledOperationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends AbstractParser {
    private static final Pattern PARAGRAPH = Pattern.compile("(\\s{4}.+?)(\\s{4}|$)");

    public TextParser(){
        super(new ParagraphParser());
    }

    @Override
    public TextComponent parse(String stringForParsing) {
        // parsing to parag
        TextComponent textComponent = new TextComposite();
        Matcher matcher = PARAGRAPH.matcher(stringForParsing);
//        String[] paragraphArray = stringForParsing.split(" ");
        TextComponent childComponent;
        int indexEnd = 0;
        while (matcher.find(indexEnd)){
            int indexStart = matcher.start(1);
            indexEnd = matcher.start(2);
            String paragraph = stringForParsing.substring(indexStart, indexEnd);
            childComponent = parseNext(paragraph);
            try{
                textComponent.add(childComponent);
            } catch (UnhandledOperationException e){
                System.out.println("incorrect chain structure");
            }
        }

//        for (String parag : paragraphArray){
//            childComponent = parseNext(parag);
//            try{
//                textComponent.add(childComponent);
//            } catch (UnhandledOperationException e){
//                System.out.println("incorrect chain structure");
//            }
//
//        }
        return textComponent;
    }
}
