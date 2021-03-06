package com.shark.example.controller;

import com.shark.example.aop.AopTest;
import com.shark.example.service.message.GetMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/message")
@RestController
public class MessageController {

    private final GetMessageService getMessageService;

    @GetMapping("/getMessage")
    @AopTest
    public String getMessage(){
        return getMessageService.getMessage();
    }

}
