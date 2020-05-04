package by.epamtraining.iht.reader.impl;

import by.epamtraining.iht.exception.FileReaderException;
import by.epamtraining.iht.exception.SourceFileNotFoundException;
import by.epamtraining.iht.reader.Reader;
import by.epamtraining.iht.validation.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader implements Reader {
    private static Logger logger = LogManager.getLogger();

    public String readStrings(String fileName) throws SourceFileNotFoundException, FileReaderException{
        logger.info("parameter: String: " + fileName);
        Path filePath = Paths.get(fileName);
        FileValidator validator = new FileValidator();
        if(validator.isEmptyFile(filePath)){
            logger.fatal("file is empty");
            throw new FileReaderException(" file is empty");
        }
        try (Stream<String> streamLines = Files.lines(filePath)){
            String resultString = streamLines.collect(Collectors.joining());
            logger.info("result String: " + resultString);
            return resultString;
        } catch (IOException e){
            logger.fatal("IOException");
            throw new FileReaderException("IOException", e);
        }
    }
}
