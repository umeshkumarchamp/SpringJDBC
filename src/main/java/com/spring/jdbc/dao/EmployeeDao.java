package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.model.Employee;

public interface EmployeeDao {

    public int addEmployee(Employee emp);

    public int updateEmployee(Employee emp);

    public int deleteEmployee(int empId);

    public Employee getEmployeeById(int empId);

    public List<Employee> getEmployeeList();
    
}
