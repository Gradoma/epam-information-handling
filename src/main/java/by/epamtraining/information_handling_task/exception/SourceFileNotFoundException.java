package by.epamtraining.information_handling_task.exception;

public class SourceFileNotFoundException extends Exception {
    static final long serialVersionUID = 1L;

    public SourceFileNotFoundException(){
        super();
    }

    public SourceFileNotFoundException(String message){
        super(message);
    }

    public SourceFileNotFoundException(Exception e){
        super(e);
    }

    public SourceFileNotFoundException(String message, Exception e){
        super(message, e);
    }
}
