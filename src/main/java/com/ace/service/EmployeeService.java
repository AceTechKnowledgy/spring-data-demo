package com.ace.service;

import com.ace.entity.Employee;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();//Read
    Employee getEmployee(int empId);//Read
    int createEmployee(Employee employee);//Post
    Employee updateEmployee(Employee employee);//Update
    void deleteEmployee(int empId);//Delete
    List<Employee> getEmployeesByName(String name);
    Employee getEmployeeByNameAndAddress(String name, String address);
    List<Employee> findBySalary(long salary);
    List<Employee> findByAddress(@Param("addr") String address);
    Employee findByIdAndName(int id, String name);
}
