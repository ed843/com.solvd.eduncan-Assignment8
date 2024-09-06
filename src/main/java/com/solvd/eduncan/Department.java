package com.solvd.eduncan;

import java.util.HashSet;
import java.util.Set;

public class Department extends Company implements Manageable {
    private final String departmentName;
    private static int totalDepartments;
    private static final int MAX_DEPARTMENTS = 10;
    private String currentTask;
    private Set<Employee> employees;

    static {
        totalDepartments = 0;
        System.out.println("Department tracking initialized");
    }

    public Department(String name, String location, String departmentName) {
        super(name, location);
        if (totalDepartments < MAX_DEPARTMENTS) {
            this.departmentName = departmentName;
            totalDepartments++;
        } else {
            throw new DepartmentLimitExceededException("Maximum number of departments reached.");
        }
        this.employees = new HashSet<Employee>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + departmentName;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + departmentName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Department department = (Department) obj;
        return departmentName.equals(department.getDepartmentName());
    }

    @Override
    public void assignTask(String task) {
        currentTask = task;
    }

    @Override
    public void reportProgress() {
        System.out.println("Still working on " + currentTask + ".");
    }

    @Override
    public String getStatus() {
        if (currentTask.equals("")) {
            return "Currently free";
        } else {
            return "Working on " + currentTask + ".";
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Set<Employee> getEmployees() {
        return new HashSet<>(employees);
    }
}
