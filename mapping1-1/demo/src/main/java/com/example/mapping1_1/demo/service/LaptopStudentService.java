package com.example.mapping1_1.demo.service;

import com.example.mapping1_1.demo.dto.LaptopDto;
import com.example.mapping1_1.demo.entity.Laptop;
import com.example.mapping1_1.demo.entity.Student;
import com.example.mapping1_1.demo.repository.LaptopRepo;
import com.example.mapping1_1.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class LaptopStudentService {
    @Autowired
    private LaptopRepo laptopRepository;

    @Autowired
    private StudentRepo studentRepository;

    @Transactional
    public LaptopDto saveLaptop(Laptop laptop) {

        Laptop laptops=laptopRepository.save(laptop);
        LaptopDto laptopDto=new LaptopDto();
        laptopDto.setLaptopName(laptops.getlName());
        laptopDto.setId(laptops.getlId());
        return laptopDto;

    }

    public Optional<Laptop> getLaptopById(int id) {
        return laptopRepository.findById(id);
    }

    @Transactional
    public void deleteLaptop(int id) {
        laptopRepository.deleteById(id);
    }

    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Laptop mapStudentToLaptop(int laptopId, int studentId) {
        Laptop laptop = laptopRepository.findById(laptopId)
                .orElseThrow(() -> new RuntimeException("Laptop not found with ID: " + laptopId));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));
        laptop.setStudent(student);
        return laptopRepository.save(laptop);
    }
}
