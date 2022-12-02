package com.weblab.backend.controllers;

import com.weblab.backend.models.Departments;
import com.weblab.backend.repositories.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
@RequestMapping("/api/departments")
public class DepartmentsController {
    private final DepartmentsRepository departmentsRepository;

    @Autowired
    public DepartmentsController(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    @GetMapping("/all")
    public Iterable<Departments> getAllDepartments(){
        return departmentsRepository.findAll();
    }
}
