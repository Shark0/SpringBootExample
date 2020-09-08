package com.shark.example.controller;


import com.shark.example.aop.AopTest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/aop")
@RestController
public class AopController {

    @AopTest
    @GetMapping("/test")
    public boolean test() {
        return true;
    }
}
