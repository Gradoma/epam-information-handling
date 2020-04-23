package by.epamtraining.iht;

import by.epamtraining.iht.composite.Component;
import by.epamtraining.iht.composite.impl.TextComposite;
import by.epamtraining.iht.parser.AbstractParser;
import by.epamtraining.iht.parser.TextParser;
import by.epamtraining.iht.reader.reader.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws Exception{
        String name = "text_file.txt";

        FileReader reader = new FileReader();
        String textString = reader.getStrings(name);
        System.out.println(textString);

        AbstractParser parser = new TextParser();
        Component textComponent = parser.parse(textString);
        String sourceText = textComponent.toString();

        System.out.println("result=" + sourceText);

        TextComposite textComposite = (TextComposite)textComponent;
        List<Component> list = textComposite.getChildComponents();
        for (Component c : list){
            String s = c.toString();
            System.out.println("child=" + s);
        }
    }
}
