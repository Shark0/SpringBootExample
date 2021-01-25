package com.shark.example.dao.example1.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "airplane")
public class AirplaneDo implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer price;
}
