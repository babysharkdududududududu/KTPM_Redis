package com.example.controller;

import com.example.entity.Employee;
import com.example.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {



    //redis
    @Autowired
    private EmpRepository empRepository;
    @PostMapping("/employees")
    public Employee saveEmp(@RequestBody Employee employee){
        empRepository.save(employee);
        return employee;
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable("id") Integer id){
        return empRepository.findById(id);
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return empRepository.findAll();
    }
    @PutMapping("/{employees}")
    public void update(@RequestBody Employee employee){
        empRepository.update(employee);
    }
    @DeleteMapping("/employees/{id}")
        public void delete(@PathVariable("id") Integer id){
        empRepository.delete(id);
    }
}
