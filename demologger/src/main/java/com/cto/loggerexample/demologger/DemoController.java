package com.cto.loggerexample.demologger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static Logger logger = LogManager.getLogger();

    @RequestMapping("/")
    public String base() {
        logger.info("Logging from basepath /: Hello");
        return "Hello from SpringBoot!";
    }

    @RequestMapping("/logs/{logType}")
    public String logsUrl(@PathVariable("logType") String logType) {
        StringBuilder message = new StringBuilder();
        switch (logType) {
            case "info":
                logger.info("Logging from /logs/info: Springboot says nice Info");
                message.append("Springboot says nice Info");
                break;
            case "debug":
                logger.debug("Logging from /logs/debug: Springboot says ok debugging!");
                message.append("Springboot says ok debugging!");
                break;
            case "error":
                logger.error("Logging from /logs/error: Springboot says Whoops ERROR!");
                message.append("Springboot says Whoops ERROR!");
                break;
            case "warn":
                logger.warn("Logging from /logs/warn: Springboot says I am WARNING you");
                message.append("Springboot says I am WARNING you");
                break;
            default:
                logger.debug("Logging from /logs/default: Springboot says we are working on it");
                message.append("Springboot says we are working on it");
                break;
        }
        return message.toString();
    }
}