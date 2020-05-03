package by.epamtraining.iht.reader;

import by.epamtraining.iht.exception.SourceFileNotFoundException;

public interface Reader {
    String readStrings(String fileName) throws SourceFileNotFoundException, Exception;
}
