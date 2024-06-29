package org.example.model;

import java.util.List;

public class Department {

    private Integer id;
    private String name;
    private String location;
    private List<Employee> employees;

    public Integer getId() {
        return id;
    }

    public Department setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Department setLocation(String location) {
        this.location = location;
        return this;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Department setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }
}
