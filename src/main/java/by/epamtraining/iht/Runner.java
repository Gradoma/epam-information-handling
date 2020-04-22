package by.epamtraining.iht;

import by.epamtraining.iht.composite.Component;
import by.epamtraining.iht.parser.AbstractParser;
import by.epamtraining.iht.parser.TextParser;
import by.epamtraining.iht.reader.reader.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws Exception{
        String name = "text_file.txt";

        FileReader reader = new FileReader();
        String textString = reader.getStrings(name);
        System.out.println(textString);

//        Pattern PARAGRAPH = Pattern.compile("(\\s{4}.+?)(\\s{4}|$)");
//        Matcher matcher = PARAGRAPH.matcher(textString);
//        int indexEnd = 0;
//        while (matcher.find(indexEnd)){
//            int indexStart = matcher.start(1);
//            indexEnd = matcher.start(2);
//            String parag = textString.substring(indexStart, indexEnd);
//            System.out.print("parag=|" + parag);
//            System.out.println("|= end of parag");
//        }
//        System.out.println("end");
        AbstractParser parser = new TextParser();
        Component textComponent = parser.parse(textString);
        String sourceText = textComponent.toString();

        System.out.println("result=" + sourceText);
    }
}
