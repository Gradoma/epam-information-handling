package by.epamtraining.iht.parser;

import by.epamtraining.iht.composite.Component;
import by.epamtraining.iht.composite.impl.Symbol;
import by.epamtraining.iht.composite.impl.TextComposite;
import by.epamtraining.iht.exception.UnhandledOperationException;

public class LexemParser extends AbstractParser {

    public LexemParser(){
        super(null);
    }

    @Override
    public Component parse(String stringForParsing) {
        //
        Component lexemComponent = new TextComposite();
        char[] charArray = stringForParsing.toCharArray();
        Component symbol;
        for (char c : charArray){
            symbol = new Symbol(c);
            try{
                lexemComponent.add(symbol);
            } catch (UnhandledOperationException e){
                System.out.println("incorrect chain structure");
            }

        }
        return lexemComponent;
    }
}
