package com.bps.sw.model.spring_boot_servlet_initializer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Moazen on 9/8/2018.
 */

@RestController
public class ModelServletInitializer {
    @RequestMapping ("/test1")
    public String firstSpringBootRest () {
        return "spring_boot_servlet_initializer";
    }
}
