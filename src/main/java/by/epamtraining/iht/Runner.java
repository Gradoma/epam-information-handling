package by.epamtraining.iht;

import by.epamtraining.iht.entity.TextComponent;
import by.epamtraining.iht.parser.AbstractParser;
import by.epamtraining.iht.parser.impl.TextParser;
import by.epamtraining.iht.reader.impl.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws Exception{
        String name = "src/main/resources/file/text_file.txt";

        FileReader reader = new FileReader();
        String textString = reader.readStrings(name);
        System.out.println(textString);

        AbstractParser parser = new TextParser();
        TextComponent textComponent = parser.parse(textString);
        String sourceText = textComponent.toString();

        System.out.println("result=" + sourceText);

//        TextComposite textComposite = (TextComposite)textComponent;
//        List<TextComponent> list = textComposite.getChildComponents();
//        for (TextComponent c : list){
//            String s = c.toString();
//            System.out.println("child=" + s);
//        }

//        TextAction action = new TextAction();
//        action.sortParagBySentences(textComponent);
//        System.out.println(textComponent.getChildComponents());
//
//
//        System.out.println("longest=" + action.findSentenceWithLongestWord(textComponent));
//
//        action.removeSentences(textComponent, 5);
//        System.out.println("after remove=" + textComponent.toString());

//        action.findIdenticalLexems(textComponent);
    }
}
