package com.shark.example.controller;

import com.shark.example.service.async.StartAsyncTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping(value = "/async")
@Controller
public class AsyncTaskController {

    private final StartAsyncTaskService startAsyncTaskService;

    @GetMapping("/start")
    public String start(){
        startAsyncTaskService.start();
        return "start";
    }
}
