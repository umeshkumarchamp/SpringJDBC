package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.config.JdbcConfig;
import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.model.Employee;

/**
 * Module : Spring JDBC
 * Author : Umesh Kumar
 * Date : 17-11-2023
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println(
                "<================================== S P R I N G   J D B C ==================================>");

        // ApplicationContext con = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

        // Initialize the Spring context with the Java-based configuration
        AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext(JdbcConfig.class);
        System.out.println(con);
        System.out.println();
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("<============================== Employee Management ==============================>");
            System.out.println(
                    "Add Employee : 1\nUpdate Employee : 2\nDelete Employee : 3\nGet Employee Details By Id : 4\nGet Employee List : 5 \nExit : 0");
            System.out.print("Enter Your Choice : - ");
            choice = sc.nextInt();
            sc.nextLine();
            EmployeeDao empDao = con.getBean("empDaoImpl", EmployeeDao.class);
            Employee emp = new Employee();
            switch (choice) {
                case 1:
                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email : ");
                    String email = sc.nextLine();
                    System.out.print("Enter Gender : ");
                    String gender = sc.next();
                    System.out.print("Enter Phone : ");
                    Long phone = sc.nextLong();
                    empDao = con.getBean("empDaoImpl", EmployeeDao.class);
                    emp = new Employee();
                    emp.setName(name);
                    emp.setEmail(email); 
                    emp.setGender(gender);
                    emp.setPhone(phone);

                    int res = empDao.addEmployee(emp);
                    if (res > 0) {
                        System.out.println("Successfully Inserted.");
                        System.out.println(emp);
                    } else {
                        System.out.println("Something went wrong !");
                    }

                    break;
                case 2:
                    System.out.print("Enter 'id' that you want to update : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name : ");
                    name = sc.nextLine();
                    System.out.print("Enter Email : ");
                    email = sc.nextLine();
                    System.out.print("Enter Gender : ");
                    gender = sc.next();
                    System.out.print("Enter Phone : ");
                    phone = sc.nextLong();
                    empDao = con.getBean("empDaoImpl", EmployeeDao.class);
                    emp = new Employee();
                    emp.setName(name);
                    emp.setEmail(email);
                    emp.setGender(gender);
                    emp.setPhone(phone);
                    emp.setId(id);

                    res = empDao.updateEmployee(emp);
                    if (res > 0) {
                        System.out.println("Successfully Updated.");
                        System.out.println(emp);
                    } else {
                        System.out.println("Something went wrong !");
                    }
                    break;

                case 3:
                    System.out.print("Enter Your Id : ");
                    id = sc.nextInt();
                    res = empDao.deleteEmployee(id);
                    if (res > 0) {
                        System.out.println("Successfully Employee Deleted.");
                        System.out.println(id);
                    } else {
                        System.out.println("Something went wrong !");
                    }
                    break;
                case 4:
                    System.out.print("Enter Your Id : ");
                    id = sc.nextInt();
                    Employee employee = empDao.getEmployeeById(id);
                    if (employee != null) {
                        System.out.println("\nDetails Fetched Successfully.");
                        System.out.println(employee);
                    }
                    break;

                case 5:
                    List<Employee> empList = empDao.getEmployeeList();
                    for (Employee e : empList) {
                        System.out.println(e);
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice !");
                    break;
            }
        } while (choice != 0);

        sc.close();
        con.close();
        // =============================== Second Way ===============================

        // EmployeeDao empDao = con.getBean("empDaoImpl", EmployeeDao.class);
        // Employee emp = new Employee();
        // emp.setName("Anil Kapoor");
        // emp.setEmail("anil@gmail.com");
        // emp.setGender("male");
        // emp.setPhone(7059344858L);
        // emp.setId(6);

        // int res = empDao.update(emp);
        // if (res > 0) {
        // System.out.println("Successfully updated");
        // } else {
        // System.out.println("Something went wrong !");
        // }

        // ================================= First Way
        // =======================================

        // JdbcTemplate jdbcTemplate = con.getBean("jdbcTemplate", JdbcTemplate.class);
        // // insert Query
        // String query = "INSERT INTO employees (name, email, gender, phone)
        // VALUES(?,?,?,?)";
        // int res = jdbcTemplate.update(query, "Rahul Kumar", "rahul@gmail.com",
        // "male",6201033951L);
        // if(res>0){
        // System.out.println("Record Inserted");
        // }else{
        // System.out.println("Something went wrong !");
        // }

    }
}
