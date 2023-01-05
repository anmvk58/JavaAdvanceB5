package com.anmv.service;

import com.anmv.entity.Department;

import java.util.List;

public interface IDepartmentService {
    public List<Department> getAllDepartments();

    public Department getDepartmentById(int id);

    public Department getDepartmentByName(String name);

    public void createDepartment(Department department);

    public void updateDepartment(int id, String newName);

    public void updateDepartment(Department department);

    public void deleteDepartment(int id);

    public boolean isDepartmentExistsById(int id);

    public boolean isDepartmentExistsByName(String name);
}
