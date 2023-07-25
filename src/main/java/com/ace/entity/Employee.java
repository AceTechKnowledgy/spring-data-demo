package com.ace.entity;

import javax.persistence.*;

@Entity(name = "emp")
@Table(name = "employee")
@NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM emp e WHERE e.salary = ?1")
@NamedNativeQuery(name = "Employee.findByAddress", query = "SELECT * FROM employee WHERE address = :addr", resultClass = Employee.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String name;
    private String address;
    private long salary;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
