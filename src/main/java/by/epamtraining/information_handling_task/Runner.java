package by.epamtraining.information_handling_task;

import by.epamtraining.information_handling_task.parser.TextParser;
import by.epamtraining.information_handling_task.reader.reader.FileReader;
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


        Pattern SENTENCE = Pattern.compile("\\s.+?[.?!…]");
        Matcher matcher = SENTENCE.matcher(textString);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        System.out.println("end");

    }
}
