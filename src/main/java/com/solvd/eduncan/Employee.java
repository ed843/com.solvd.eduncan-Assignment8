package com.solvd.eduncan;

public abstract class Employee implements Manageable {
    private static int totalEmployees;
    private String employeeId;
    private String name;
    private String position;
    private Department department;

    static {
        totalEmployees = 0;
    }

    public Employee(String employeeId, String name, String position, Department department) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.department = department;
        totalEmployees++;
    }



    public static int getTotalEmployees() {
        return totalEmployees;
    }

    final String getEmployeeId() {
        return employeeId;
    }

    void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
    String getPosition() {
        return position;
    }
    void setPosition(String position) {
        this.position = position;
    }
    Department getDepartment() {
        return department;
    }

    void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public abstract void assignTask(String task);

    @Override
    public abstract void reportProgress();

    @Override
    public abstract String getStatus();

    // Abstract method
    public abstract void performDuties();

    @Override
    public String toString() {
        return "Employee{employeeId='" + employeeId + "', name='" + name + "', position='" + position + "'}";
    }
}

