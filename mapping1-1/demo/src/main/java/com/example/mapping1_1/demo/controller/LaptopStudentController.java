package com.example.mapping1_1.demo.controller;

import com.example.mapping1_1.demo.dto.LaptopDto;
import com.example.mapping1_1.demo.entity.Laptop;
import com.example.mapping1_1.demo.entity.Student;
import com.example.mapping1_1.demo.service.LaptopStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LaptopStudentController {

    @Autowired
    private LaptopStudentService laptopService;

    @PostMapping("/laptops")

    public LaptopDto createLaptop(@RequestBody Laptop laptop) {
        return laptopService.saveLaptop(laptop);
    }

    @GetMapping("/laptops/{id}")
    public Optional<Laptop> getLaptop(@PathVariable int id) {
        return laptopService.getLaptopById(id);
    }

    @DeleteMapping("/laptops/{id}")
    public String deleteLaptop(@PathVariable int id) {
        laptopService.deleteLaptop(id);
        return "Laptop deleted successfully!";
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return laptopService.saveStudent(student);
    }

    @PutMapping("/laptops/{laptopId}/map-student/{studentId}")
    public Laptop mapStudentToLaptop(@PathVariable int laptopId, @PathVariable int studentId) {
        return laptopService.mapStudentToLaptop(laptopId, studentId);
    }

}
