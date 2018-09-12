package com.bps.sw.model.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Moazen on 9/11/2018.
 */

@RestController
public class logging {

    private static final Logger logger = LoggerFactory.getLogger(logging.class);

    @RequestMapping(value = "/log")
    public static void doLog() {
        for (int i=0;i<20000;i++) {
            logger.info("this is a info message");
            logger.warn("this is a warn message");
            logger.error("this is a error message");
            System.out.println("log is generated successfully");
        }
    }
}
