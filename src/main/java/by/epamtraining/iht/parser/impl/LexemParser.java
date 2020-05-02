package by.epamtraining.iht.parser.impl;

import by.epamtraining.iht.composite.TextComponent;
import by.epamtraining.iht.composite.impl.Symbol;
import by.epamtraining.iht.composite.impl.TextComposite;
import by.epamtraining.iht.exception.UnhandledOperationException;
import by.epamtraining.iht.parser.AbstractParser;

public class LexemParser extends AbstractParser {

    public LexemParser(){
        super(null);
    }

    @Override
    public TextComponent parse(String stringForParsing) {
        //
        TextComponent lexemComponent = new TextComposite();
        char[] charArray = stringForParsing.toCharArray();
        TextComponent symbol;
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
