package me.asedov._hw5.controller;

import me.asedov._hw5.Employee;
import me.asedov._hw5.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public String add(@RequestParam String surname, @RequestParam String name) {
        Employee result = employeeService.add(surname, name);
        return generateMessage(result, "Успешно создан");
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String surname, @RequestParam String name) {
        Employee result = employeeService.remove(surname, name);
        return generateMessage(result, "Удален");
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String surname, @RequestParam String name) {
        return employeeService.find(surname, name);
    }

    @GetMapping
    public Collection<Employee>findAll(){
        return employeeService.findAll();
    }
    private String generateMessage(Employee employee, String status){
        return String.format("Сотрудник %s %s %s.", employee.getSurname(), employee.getName(),status);
    }

}
