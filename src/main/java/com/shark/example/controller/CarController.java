package com.shark.example.controller;


import com.shark.example.dao.example.pojo.CarDo;
import com.shark.example.dao.example.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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


    @Transactional(transactionManager = "exampleTransactionManager", rollbackFor = Exception.class)
    @PostMapping()
    public CarDo create(boolean exception) {
        CarDo carDo = new CarDo();
        carDo.setName("Test");
        carDo.setPrice(99);
        carDo.setCreateTime(new Date());
        carDo = carRepository.save(carDo);
        if(exception) {
            int value = 1 / 0;
            System.out.println("value: " + value);
        }
        return carDo;
    }
}
