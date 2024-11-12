package me.asedov._hw5.service;

import me.asedov._hw5.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String name, String surname);

    Employee add(Employee employee);

    Employee remove(String name, String surname);

    Employee remove(Employee employee);

    Employee find(String name, String surname);

    Collection<Employee>findAll();


}
