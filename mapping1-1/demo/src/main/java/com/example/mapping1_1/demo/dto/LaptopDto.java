package com.example.mapping1_1.demo.dto;

import lombok.Getter;
import lombok.Setter;


public class LaptopDto {
    private int id;
    private String laptopName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }
}
