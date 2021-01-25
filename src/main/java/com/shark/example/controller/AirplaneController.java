package com.shark.example.controller;


import com.shark.example.dao.example1.pojo.AirplaneDo;
import com.shark.example.dao.example1.repository.AirplaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/airplane")
@RestController
public class AirplaneController {

    private final AirplaneRepository airplaneRepository;

    @GetMapping()
    public List<AirplaneDo> read() {
        return airplaneRepository.findAll();
    }
}
