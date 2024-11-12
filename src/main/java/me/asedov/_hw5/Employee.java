package me.asedov._hw5;

import java.util.Objects;

public class Employee {
    private final String surname;
    private final String name;


    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public String getSurname() {
        return surname;
    }


    public String getName() {
        return name;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public String toString() {
        return String.format("Сотрудник: %s %s", surname, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && surname.equals(employee.surname);
    }


}
