package by.epamtraining.information_handling_task.parser;

public class LexemParser extends AbstractParser {

    public LexemParser(){
        super(null);
    }

    @Override
    public void parse(String stringForParsing) {
        //
        String s = stringForParsing + " lexem ";
        System.out.println(s);
        parseNext(s);
    }
}
