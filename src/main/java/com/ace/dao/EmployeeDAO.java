package com.ace.dao;

import com.ace.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
    List<Employee> findByName(String name);//select * from employee where name = ?
    Employee findByNameAndAddress(String name, String address);//select * from employee where name=? and address=?
    List<Employee> findBySalary(long salary);
    List<Employee> findByAddress(@Param("addr") String address);
    @Query(value = "SELECT * FROM employee WHERE emp_id = ?1 and name = ?2", nativeQuery = true)
    Employee findByIdAndName(int id, String name);
}
