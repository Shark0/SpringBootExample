package com.shark.example.controller;

import com.shark.example.asyncTask.ExceptionAsyncTask;
import com.shark.example.service.async.StartAsyncTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    private final ExceptionAsyncTask exceptionAsyncTask;

    @PostMapping("/exception")
    public boolean exception(@RequestBody String body){
        exceptionAsyncTask.start(body);
        return true;
    }
}
