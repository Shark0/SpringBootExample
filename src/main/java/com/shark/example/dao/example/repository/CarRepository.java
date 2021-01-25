package com.shark.example.dao.example.repository;

import com.shark.example.dao.example.pojo.CarDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarDo, Integer> {

}
