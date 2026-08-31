package com.eidiko.logging.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoggingService {
    public void normalLogging(){
        log.info("Normal logging started");
        log.debug("Debug message from service");
        log.warn("Warning message from service");
        log.info("Normal logging completed");
    }

    @Async("loggingTaskExecutor")
    public void asyncTask(String taskName){

        log.info("Async task started : {}",taskName);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            log.error("Async task interrupted : {}",taskName,e);
        }
        log.info("Async task completed : {}",taskName);
    }

    public void generateError(){
        log.info("starting error test");
        try{
            int res = 10/0;
        }catch (Exception e){
            log.error("Exception occurred while processing request",e);
        }
    }
}
