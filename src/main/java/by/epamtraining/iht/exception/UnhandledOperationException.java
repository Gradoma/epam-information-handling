package by.epamtraining.iht.exception;

public class UnhandledOperationException extends Exception {
    static final long serialVersionUID = 1L;

    public UnhandledOperationException(){
        super();
    }

    public UnhandledOperationException(String message){
        super(message);
    }

    public UnhandledOperationException(Exception e){
        super(e);
    }

    public UnhandledOperationException(String message, Exception e){
        super(message, e);
    }
}
