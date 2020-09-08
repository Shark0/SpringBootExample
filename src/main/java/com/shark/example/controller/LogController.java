package com.shark.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(value = "/log")
@RestController
public class LogController {

    @PostMapping()
    public boolean log(@RequestBody String body){
        log.info("body: {}", body);
        log.trace("body: {}", body);
        log.warn("body: {}", body);
        try {
            body = body.substring(10000);
        } catch (Exception e) {
            log.error("error: ", e);
        }
        return true;
    }
}
