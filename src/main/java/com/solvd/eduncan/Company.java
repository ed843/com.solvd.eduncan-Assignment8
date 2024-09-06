package com.solvd.eduncan;

import java.util.ArrayList;
import java.util.List;

public class Company implements Auditable {
    private final String name;
    private final String location;
    private static String auditLog;
    private List<Department> departments;
    public Company(String name, String location) {
        this.name = name;
        this.location = location;
        this.departments = new ArrayList<Department>();
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
}

