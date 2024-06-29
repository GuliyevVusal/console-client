package org.example.model;

import java.util.List;

public class MainResponse {

        private int statusCode;
        private String message;
        private List<Department> departments;

    public MainResponse(int statusCode, String message, List<Department> departments) {
        this.statusCode = statusCode;
        this.message = message;
        this.departments = departments;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public MainResponse setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MainResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public MainResponse setDepartments(List<Department> departments) {
        this.departments = departments;
        return this;
    }
}


