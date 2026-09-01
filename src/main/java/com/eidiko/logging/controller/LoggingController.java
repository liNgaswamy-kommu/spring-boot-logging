package com.eidiko.logging.controller;

import com.eidiko.logging.service.LoggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logging")
@RequiredArgsConstructor
@Slf4j
public class LoggingController {
    private final LoggingService loggingService;

    @GetMapping("/test")
    public String testLogging(){
        log.info("Request received for Normal logging");
        loggingService.normalLogging();
        log.info("Normal logging request completed");
        return "Logging test completed";
    }

    @GetMapping("/error")
    public String errorLogging(){

        log.info("Received request for error logging");
        loggingService.generateError();
        return "Error logging completed";
    }

    @GetMapping("/multi-thread")
    public String multiThreadLogging() {

        log.info("Received multi-thread logging request");

        for (int i = 1; i <= 5; i++) {
            loggingService.asyncTask("Task-" + i );
        }

        log.info("Submitted all async tasks");
        return "5 async tasks submitted";
    }
}





