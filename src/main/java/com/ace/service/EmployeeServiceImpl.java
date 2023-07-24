package com.ace.service;

import com.ace.dao.EmployeeDAO;
import com.ace.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeDAO.findAll().forEach(employees::add);

        return employees;
    }

    @Override
    public Employee getEmployee(int empId) {
        return employeeDAO.findById(empId).orElse(null);
    }

    @Override
    public int createEmployee(Employee employee) {
        Employee emp = employeeDAO.save(employee);

        return emp.getEmpId();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public void deleteEmployee(int empId) {
        employeeDAO.deleteById(empId);
    }
}
