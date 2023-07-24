package com.ace.service;

import com.ace.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();//Read
    Employee getEmployee(int empId);//Read
    int createEmployee(Employee employee);//Post
    Employee updateEmployee(Employee employee);//Update
    void deleteEmployee(int empId);//Delete
}
