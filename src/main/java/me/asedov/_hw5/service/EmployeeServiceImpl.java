package me.asedov._hw5.service;

import me.asedov._hw5.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final Set<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashSet<>();
    }

    @Override
    public Employee add(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        if (employees.contains(employee)) {
            throw new EmployeeExistsException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        if (!employees.contains(newEmployee)) {
            throw new EmployeeNotFoundException();
        }
        return newEmployee;
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
    }
}
