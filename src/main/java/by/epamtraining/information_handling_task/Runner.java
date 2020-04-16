package by.epamtraining.information_handling_task;

import by.epamtraining.information_handling_task.parser.TextParser;
import by.epamtraining.information_handling_task.reader.reader.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws Exception{
//        String name = "text_file.txt";
//
//        FileReader reader = new FileReader();
//        String textString = reader.getStrings(name);
//        System.out.println(textString.contains("\n"));
//        System.out.println(textString);

        TextParser textParser = new TextParser();
        textParser.parse("example");
    }
}
