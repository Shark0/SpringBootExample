package com.shark.example.controller;


import com.shark.example.dao.example.pojo.CarDo;
import com.shark.example.dao.example.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/car")
@RestController
public class CarController {

    private final CarRepository carRepository;
    @GetMapping()
    public List<CarDo> read() {
        return carRepository.findAll();
    }
}
