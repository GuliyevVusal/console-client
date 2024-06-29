package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.model.Department;
import org.example.model.Employee;

import java.util.Arrays;
import java.util.List;

import static org.example.util.File.writeDepartmentsToFile;

public class App {
    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("http://localhost:9090/rest/departments/client");
            CloseableHttpResponse response = httpClient.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());

            ObjectMapper objectMapper = new ObjectMapper();
            Department[] departmentsArray = objectMapper.readValue(responseBody, Department[].class);
            List<Department> departments = Arrays.asList(departmentsArray);

            printDepartments(departments);

            writeDepartmentsToFile(departments, "departments.txt");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printDepartments(List<Department> departments) {
        for (Department department : departments) {
            System.out.println("Department: " + department.getId());
            System.out.println("Department: " + department.getName());
            System.out.println("Location: " + department.getLocation());
            System.out.println("Employees:");
            for (Employee employee : department.getEmployees()) {
                System.out.println(" - " +employee.getId() + ": " + employee.getName() +
                        " " + employee.getSurname() + " (" + employee.getEmail() + ")");
            }
            System.out.println("-------------------");
        }
    }

}
