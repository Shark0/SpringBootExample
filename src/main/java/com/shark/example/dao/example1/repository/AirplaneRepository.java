package com.shark.example.dao.example1.repository;

import com.shark.example.dao.example1.pojo.AirplaneDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<AirplaneDo, Integer> {

}
