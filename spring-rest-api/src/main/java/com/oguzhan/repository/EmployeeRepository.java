package com.oguzhan.repository;

import com.oguzhan.model.Employee;
import com.oguzhan.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList(){
        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)){
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        List<Employee> employeeListwithParams = new ArrayList<>();

        if (firstName == null && lastName == null){
            return employeeList;
        }
        else if (firstName != null && lastName != null){
            for (Employee employee : employeeList) {
                if (employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeListwithParams.add(employee);
                }
            }
        }
        else if (firstName != null && lastName == null){
            for (Employee employee : employeeList) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)){
                    employeeListwithParams.add(employee);
                }
            }
        }
        else {
            for (Employee employee : employeeList) {
                if (employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeListwithParams.add(employee);
                }
            }
        }
        return employeeListwithParams;
    }

    public Employee saveEmployee(Employee newEmployee){
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(String id){
        Employee employee = null;
        for(int i = 0; i < this.employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                employee = employeeList.get(i);
                break;
            }
        }
        if (employee == null) {
            return false;
        }
        employeeList.remove(employee);
        return true;
    }
    public Employee updateEmployee(String id, UpdateEmployeeRequest updateEmployeeRequest){
        Employee employee = null;
        for(int i = 0; i < this.employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                employee = employeeList.get(i);
                break;
            }
        }
        if (employee == null) {
            return null;
        }
        employee.setFirstName(updateEmployeeRequest.getFirstName());
        employee.setLastName(updateEmployeeRequest.getLastName());
        return employee;
    }
}
