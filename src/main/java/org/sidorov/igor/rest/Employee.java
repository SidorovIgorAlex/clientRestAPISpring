package org.sidorov.igor.rest;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
//    @Min(value = 2, message = "Имя должно состоять минимум из двух символов")
//    @Pattern(regexp = "^[a-zA-Z]*$", message = "Имя содержит невалидные символы")
    private String name;
    @Column(name = "surname")
//    @Pattern(regexp = "^[a-zA-Z]*$", message = "Фамилия содержит невалидные символы")
//    @Min(value = 2, message = "Фамилия должна состоять минимум из двух символов")
    private String surName;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
//    @Pattern(regexp = "\\d*", message = "Зарплата должна состоять только из цифр")
    private int salary;

    public Employee(String name, String surName, String department, int salary) {
        this.name = name;
        this.surName = surName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
