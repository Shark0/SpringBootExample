package com.shark.example.controller;

import com.shark.example.service.async.StartAsyncTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/async")
@RestController
public class AsyncTaskController {

    private final StartAsyncTaskService startAsyncTaskService;

    @GetMapping("/start")
    public boolean start(){
        startAsyncTaskService.start();
        return true;
    }
}
