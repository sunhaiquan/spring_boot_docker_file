package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@RestController
public class TestApplication {

    //private final static Logger logger = LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @RequestMapping("/")
    public String test(){
        //logger.info("aaaaaaaaa>>>>");
        log.info("aaaaaaaaa>>>>");
        return "aaa";
    }
}
