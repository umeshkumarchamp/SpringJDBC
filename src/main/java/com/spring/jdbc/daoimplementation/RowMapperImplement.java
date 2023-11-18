package com.spring.jdbc.daoimplementation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.model.Employee;

public class RowMapperImplement implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        Employee emp = new Employee(); 
        emp.setId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setEmail(rs.getString("email"));
        emp.setGender(rs.getString("gender"));
        emp.setPhone(rs.getLong("phone"));
        return emp;
       
    }
    
}
