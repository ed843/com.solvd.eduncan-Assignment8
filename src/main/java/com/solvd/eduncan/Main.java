package com.solvd.eduncan;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company techCompany = new Company("Tech Solutions", "New York");
        Department department1 = new Department("IT Department", "New York", DepartmentType.IT);
        Department department2 = new Department("Advertising Department", "New York", DepartmentType.MARKETING);

        techCompany.addDepartment(department1);
        techCompany.addDepartment(department2);

        Developer developer = new Developer("John Doe", EmployeeLevel.SENIOR, department1, new ArrayList<>(), 75000, 5);
        techCompany.addEmployee(developer);
        developer.addTechnology(TechnologyStack.JAVA);
        developer.addTechnology(TechnologyStack.PYTHON);
        developer.addBenefit(CompanyBenefit.HEALTH_INSURANCE);
        developer.addBenefit(CompanyBenefit.RETIREMENT_PLAN);

        Project webProject = new Project("P001", "New Website", 50000);
        webProject.changeStatus(ProjectStatus.IN_PROGRESS);

        NumberFormat formatter = new DecimalFormat("#0.00");

        System.out.println("Employee Level: " + developer.getEmployeeLevel().getTitle());
        System.out.println("Employee Bonus: $" + formatter.format(developer.calculateBonus()));
        System.out.println("Employee Tech Stack: " + developer.getTechStack());
        techCompany.sortEmployeesByPay();
        System.out.println(techCompany.getEmployees());
        System.out.println("Employee Benefits Cost: $" + formatter.format(developer.calculateTotalBenefitsCost()));
        System.out.println("Project Status: " + webProject.getStatus());
        System.out.println("Project Active: " + webProject.isActive());
        System.out.println("Company Departments: " + techCompany.getDepartments());

        // testing reflection
        Company.reflectionDemo();
    }
}