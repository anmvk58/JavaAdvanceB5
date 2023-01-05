package com.anmv.service;

import com.anmv.entity.Department;
import com.anmv.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public List<Department> getAllDepartments() {
        return repository.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(int id) {
        return repository.getDepartmentById(id);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return repository.getDepartmentByName(name);
    }

    @Override
    public void createDepartment(Department department) {
        repository.createDepartment(department);
    }

    @Override
    public void updateDepartment(int id, String newName) {
        repository.updateDepartment(id, newName);
    }

    @Override
    public void updateDepartment(Department department) {
        repository.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(int id) {
        repository.deleteDepartment(id);
    }

    @Override
    public boolean isDepartmentExistsById(int id) {
        return repository.isDepartmentExistsById(id);
    }

    @Override
    public boolean isDepartmentExistsByName(String name) {
        return repository.isDepartmentExistsByName(name);
    }
}
