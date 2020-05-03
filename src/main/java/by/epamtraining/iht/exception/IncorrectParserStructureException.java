package by.epamtraining.iht.exception;

public class IncorrectParserStructureException extends Exception {
    static final long serialVersionUID = 1L;

    public IncorrectParserStructureException(){
        super();
    }

    public IncorrectParserStructureException(String message){
        super(message);
    }

    public IncorrectParserStructureException(Exception e){
        super(e);
    }

    public IncorrectParserStructureException(String message, Exception e){
        super(message, e);
    }
}
