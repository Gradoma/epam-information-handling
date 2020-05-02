package by.epamtraining.iht.reader.impl;

import by.epamtraining.iht.exception.SourceFileNotFoundException;
import by.epamtraining.iht.reader.Reader;
import by.epamtraining.iht.validation.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader implements Reader {
    private static Logger logger = LogManager.getLogger();

    public String getStrings(String fileName) throws SourceFileNotFoundException, Exception{
        logger.info("parameter: String: " + fileName);
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceURL = classLoader.getResource(fileName);
        if (resourceURL == null){
            logger.fatal("specified file now found");
            throw new SourceFileNotFoundException("specified file now found");
        }
        logger.info("file was founded");
        URI resourceURI = resourceURL.toURI();
        Path filePath = Paths.get(resourceURI);
        FileValidator validator = new FileValidator();
        if(validator.isEmptyFile(filePath)){
            logger.fatal("file is empty");
            throw new Exception(" file is empty");
        }
        try (Stream<String> streamLines = Files.lines(filePath)){
            String resultString = streamLines.collect(Collectors.joining());
            logger.info("impl result: " + resultString);
            return resultString;
        } catch (IOException e){
            logger.fatal("IOException");
            throw new Exception("io exception", e);
        }
    }
}
