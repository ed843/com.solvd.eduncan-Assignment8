package com.solvd.eduncan;

import java.util.HashSet;
import java.util.Set;

public class Department extends Company implements Manageable {
    private final DepartmentType departmentType;
    private static int totalDepartments;
    private static final int MAX_DEPARTMENTS = 10;
    private String currentTask;
    private Set<Employee> employees;

    static {
        totalDepartments = 0;
        System.out.println("Department tracking initialized");
    }

    public Department(String name, String location, DepartmentType departmentType) {
        super(name, location);
        if (totalDepartments < MAX_DEPARTMENTS) {
            this.departmentType = departmentType;
            totalDepartments++;
        } else {
            throw new DepartmentLimitExceededException("Maximum number of departments reached.");
        }
        this.employees = new HashSet<Employee>();
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + departmentType;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + departmentType.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Department department = (Department) obj;
        return departmentType.equals(department.getDepartmentType());
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


    public Set<Employee> getDepEmployees() {
        return new HashSet<>(employees);
    }
}
