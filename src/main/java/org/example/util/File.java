package org.example.util;

import org.example.model.Department;
import org.example.model.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class File {


    public static void writeDepartmentsToFile(List<Department> departments, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Department department : departments) {
                fileWriter.write("Department ID: " + department.getId() + "\n");
                fileWriter.write("Department Name: " + department.getName() + "\n");
                fileWriter.write("Location: " + department.getLocation() + "\n");
                fileWriter.write("Employees:\n");
                for (Employee employee : department.getEmployees()) {
                    fileWriter.write(" - " + employee.getId() + ": " + employee.getName() + " " + employee.getSurname() + " (" + employee.getEmail() + ")\n");
                }
                fileWriter.write("-------------------\n");
            }
            System.out.println("Departments written to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
