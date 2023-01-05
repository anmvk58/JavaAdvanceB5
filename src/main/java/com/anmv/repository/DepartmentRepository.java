package com.anmv.repository;

import com.anmv.entity.Department;
import com.anmv.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository{
    private HibernateUtils hibernateUtils;

    public DepartmentRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    @Override
    public List<Department> getAllDepartments() {
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            Query<Department> query = session.createQuery("FROM Department ");
            return query.list();
        } finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public Department getDepartmentById(int id) {
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            Department department = session.get(Department.class, id);
            return department;
        } finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public Department getDepartmentByName(String name) {
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            Query<Department> query = session.createQuery("FROM Department WHERE departmentName = :nameParameter");
            query.setParameter("nameParameter", name);
            Department department = query.uniqueResult();
            return department;
        } finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void createDepartment(Department department) {
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.save(department);

            session.getTransaction().commit();

        } finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void updateDepartment(int id, String newName) {
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Department department = (Department) session.load(Department.class, id);
            department.setDepartmentName(newName);

            session.getTransaction().commit();

        } finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void updateDepartment(Department department) {
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.update(department);

            session.getTransaction().commit();

        } finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void deleteDepartment(int id) {
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Department department = (Department) session.load(Department.class, id);
            session.delete(department);

            session.getTransaction().commit();

        } finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public boolean isDepartmentExistsById(int id) {
        Department department = getDepartmentById(id);
        if(department == null){
            return false;
        }

        return true;
    }

    @Override
    public boolean isDepartmentExistsByName(String name) {
        Department department = getDepartmentByName(name);
        if(department == null){
            return false;
        }

        return true;
    }
}
