package by.epamtraining.iht.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidator {
    private static Logger logger = LogManager.getLogger();

    public boolean isEmptyFile(Path filePath){
        logger.info("parameter: Path: " + filePath);
        boolean result = true;
        long size;
        try{
            size = Files.size(filePath);
            logger.info("size of file = " + size);
        } catch (IOException e){
            logger.error("IOException");
            return result;
        }
        if(size > 0){
            result = false;
        }
        logger.info("result: " + result);
        return result;
    }
}
