package com.ace.controller;

import com.ace.entity.Employee;
import com.ace.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @RequestMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empId) {
        Employee employee = employeeService.getEmployee(empId);
        HttpStatus status = HttpStatus.OK;
        if (employee == null)
            status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(employee, status);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Integer> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Record Deleted", HttpStatus.OK);
    }

    @GetMapping("/employees/{name}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String name) {
        List<Employee> employees = employeeService.getEmployeesByName(name);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{name}/{address}")
    public ResponseEntity<Employee> findByName(@PathVariable String name, @PathVariable String address) {
        Employee employees = employeeService.getEmployeeByNameAndAddress(name, address);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/sal/{salary}")
    public ResponseEntity<List<Employee>> findBySalary(@PathVariable long salary) {
        List<Employee> employees = employeeService.findBySalary(salary);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/addr/{address}")
    public ResponseEntity<List<Employee>> findByAddress(@PathVariable String address) {
        List<Employee> employees = employeeService.findByAddress(address);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/id/{id}/{name}")
    public ResponseEntity<Employee> findByIdAndName(@PathVariable int id, @PathVariable String name) {
        Employee employees = employeeService.findByIdAndName(id, name);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
