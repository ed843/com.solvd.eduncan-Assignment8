package com.solvd.eduncan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class Company implements Auditable {
    private static String auditLog;
    private final String name;
    private final String location;
    private List<Department> departments;
    private List<Employee> employees;

    public Company(String name, String location) {
        this.name = name;
        this.location = location;
        this.departments = new ArrayList<Department>();
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }


    @Override
    public String toString() {
        return "Company [name=" + name + ", location=" + location + "]";
    }

    @Override
    public int hashCode() {
        return name.hashCode() + location.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Company company = (Company) obj;
        return name.equals(company.name) && location.equals(company.location);
    }

    @Override
    public void startAudit(String date) {
        auditLog += "\nCompany " + getName() + " audit started at " + date;
    }

    @Override
    public void endAudit(String date) {
        auditLog += "\nCompany " + getName() + " audit finished at " + date;
    }

    @Override
    public String getAuditLog() {
        return auditLog;
    }

    @Override
    public boolean isCompliant() {
        return false;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return new ArrayList<>(departments);
    }

    public void printEmployeeDetails() {
        Consumer<Employee> printEmployeeDetails = e -> System.out.println(e.getName() + " - " + e.getEmployeeLevel().getTitle());
        employees.forEach(printEmployeeDetails);
    }

    public List<Employee> getHighPaidEmployeeList() {
        Utils.Filter<Employee> highPaidEmployees = e -> e.getBaseSalary() > 100000;
        return Utils.filterList(employees, highPaidEmployees);
    }

    public void sortEmployeesByPay() {
        Utils.Comparator<Employee> byPay = (e1, e2) -> Double.compare(e1.getBaseSalary(), e2.getBaseSalary());
        Utils.sortList(employees, byPay);
    }

    public double calculateBonus() {
        if (employees.isEmpty()) {
            return 0;
        }
        Function<Employee, Double> calculateBonus = Employee::calculateBonus;
        return employees.stream().mapToDouble(e -> calculateBonus.apply(e)).sum();
    }


    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}

