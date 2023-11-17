package com.spring.jdbc.dao;

import com.spring.jdbc.model.Employee;

public interface EmployeeDao {

    public int addEmployee(Employee emp);

    public int updateEmployee(Employee emp);

    public int deleteEmployee(int empId);

    public int getEmployeeById(int empId);
    
}
