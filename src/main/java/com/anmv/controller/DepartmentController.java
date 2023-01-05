package com.anmv.controller;

import com.anmv.entity.Department;
import com.anmv.service.DepartmentService;
import com.anmv.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @GetMapping()
    public List<Department> getAllDepartments(){
        return service.getAllDepartments();
    }

    @GetMapping(value = "/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") int id){
        return service.getDepartmentById(id);
    }

    @GetMapping(value = "/name")
    public Department getDepartmentByName(@RequestParam(name = "name", value="") String name){
        return service.getDepartmentByName(name);
    }

    @PostMapping()
    public void createDepartment(@RequestBody Department department){
        service.createDepartment(department);
    }

    @PutMapping(value = "/{id}")
    public void updateDepartment(@PathVariable(name = "id") int id, @RequestBody Department department){
        department.setId(id);
        service.updateDepartment(department);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDepartment(@PathVariable(name = "id") int id){
        service.deleteDepartment(id);
    }

    @GetMapping(value = "/check/{id}")
    public boolean checkDepartmentExistById(@PathVariable(name = "id") int id){
        return service.isDepartmentExistsById(id);
    }

    @GetMapping(value = "/check")
    public boolean checkDepartmentExistById(@RequestParam(name = "name") String name){
        return service.isDepartmentExistsByName(name);
    }

}
