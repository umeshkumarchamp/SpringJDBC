package com.spring.jdbc.daoimplementation;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.model.Employee;

public class EmpDaoImplement implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Add a new Employee
     */
    @Override
    public int addEmployee(Employee emp) {
        String query = "INSERT INTO employees (name, email, gender, phone) VALUES(?,?,?,?)";
        int res = this.jdbcTemplate.update(query, emp.getName(), emp.getEmail(), emp.getGender(), emp.getPhone());
        return res;
    }

    /**
     * Update an existing employee
     */
    @Override
    public int updateEmployee(Employee emp) {
        String query = "UPDATE employees SET name=?, email=?, gender=?, phone=? WHERE id = ?";
        int res = this.jdbcTemplate.update(query, emp.getName(), emp.getEmail(), emp.getGender(), emp.getPhone(), emp.getId());
        return res;
    }

    /**
     * Delete an existing employee
     */
    @Override
    public int deleteEmployee(int empId) {
        String query = "DELETE FROM employees WHERE id=?";
        int res = this.jdbcTemplate.update(query, empId);
        return res; 
    }

    @Override
    public int getEmployeeById(int empId) {
        String query = "SELECT * FROM employees WHERE id=?";
       
        return 1; 
    }

}
