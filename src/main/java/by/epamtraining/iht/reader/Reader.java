package by.epamtraining.iht.reader;

import by.epamtraining.iht.exception.SourceFileNotFoundException;

public interface Reader {
    String getStrings(String fileName) throws SourceFileNotFoundException, Exception;
}
