package com.spring.jdbc.daoimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.model.Employee;

@Component("empDaoImpl")
public class EmpDaoImplement implements EmployeeDao {

    @Autowired
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

    /**
     * Get Employee details by Id...
     */
    @Override
    public Employee getEmployeeById(int empId) {
        String query = "SELECT * FROM employees WHERE id=?";
        RowMapper<Employee> rowMapper = new RowMapperImplement();
        Employee emp = this.jdbcTemplate.queryForObject(query, rowMapper, empId);
        return emp; 
    }

    @Override
    public List<Employee> getEmployeeList() {
        String query = "SELECT * FROM employees ORDER BY id";
        List<Employee> empList = this.jdbcTemplate.query(query,new RowMapperImplement());
        return empList;
    }

}
