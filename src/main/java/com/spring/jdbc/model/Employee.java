package com.spring.jdbc.model;

public class Employee {
    
    private int id; 
    private String name;
    private String email; 
    private String gender; 
    private Long phone; 


    public Employee() {
    }

    public Employee(int id, String name, String email, String gender, Long phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhone() {
        return this.phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", gender='" + getGender() + "'" +
            ", phone='" + getPhone() + "'" +
            "}";
    }



}
