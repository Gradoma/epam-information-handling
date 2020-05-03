package by.epamtraining.iht.reader.impl;

import by.epamtraining.iht.exception.FileReaderException;
import by.epamtraining.iht.exception.SourceFileNotFoundException;
import by.epamtraining.iht.reader.Reader;
import by.epamtraining.iht.validation.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader implements Reader {
    private static Logger logger = LogManager.getLogger();

    public String readStrings(String fileName) throws SourceFileNotFoundException, FileReaderException{
        logger.info("parameter: String: " + fileName);
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceURL = classLoader.getResource(fileName);
        if (resourceURL == null){
            logger.fatal("specified file not found");
            throw new SourceFileNotFoundException("specified file not found");
        }
        logger.info("file was founded");
        URI resourceURI;
        try{
            resourceURI = resourceURL.toURI();
        } catch (URISyntaxException uEx){
            logger.fatal("can't convert resource URL to URI, incorrect format");
            throw new FileReaderException(uEx);
        }
        Path filePath = Paths.get(resourceURI);
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
            throw new FileReaderException("io exception", e);
        }
    }
}
