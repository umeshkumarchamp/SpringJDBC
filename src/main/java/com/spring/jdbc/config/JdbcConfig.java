package com.spring.jdbc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.daoimplementation.EmpDaoImplement;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.daoimplementation"})
public class JdbcConfig {
    
    @Bean("ds")
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/test");
        ds.setUsername("postgres");
        ds.setPassword("root"); 
        return ds; 
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    // @Bean("empDaoImpl")
    // public EmployeeDao getEmpDao(){
    //     EmpDaoImplement empDaoImpl = new EmpDaoImplement();
    //     empDaoImpl.setJdbcTemplate(jdbcTemplate());
    //     return empDaoImpl;
    // }
}
