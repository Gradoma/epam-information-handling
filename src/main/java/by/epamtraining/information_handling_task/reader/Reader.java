package by.epamtraining.information_handling_task.reader;

import by.epamtraining.information_handling_task.exception.SourceFileNotFoundException;

public interface Reader {
    String getStrings(String fileName) throws SourceFileNotFoundException, Exception;
}
