package com.solvd.eduncan;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;


public abstract class Employee implements Manageable {
    private static int totalEmployees;
    private String employeeId;
    private String name;
    private EmployeeLevel employeeLevel;
    private Department department;
    private double baseSalary;
    private List<CompanyBenefit> benefits;
    private int yearsOfExperience;
    private BiFunction<Double, Double, Double> totalCompensationCalculator;

    static {
        totalEmployees = 0;
    }

    public Employee(String name, EmployeeLevel employeeLevel, Department department, double baseSalary, int yearsOfExperience) {
        this.employeeId = Utils.generateEmployeeId();
        this.name = name;
        this.employeeLevel = employeeLevel;
        this.department = department;
        this.baseSalary = baseSalary;
        this.yearsOfExperience = yearsOfExperience;
        this.totalCompensationCalculator = (salary, benefitsCost) -> salary + benefitsCost;
        totalEmployees++;

        this.benefits = new ArrayList<CompanyBenefit>();
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
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
    EmployeeLevel getEmployeeLevel() {
        return employeeLevel;
    }
    void setEmployeeLevel(EmployeeLevel employeeLevel) {
        this.employeeLevel = employeeLevel;
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

    public double calculateBonus() {
        return employeeLevel.calculateBonus(baseSalary);
    }

    @Override
    public String toString() {
        return "Employee{employeeId='" + employeeId + "', name='" + name + "', position='" + employeeLevel.getTitle() + "'}";
    }

    public void addBenefit(CompanyBenefit benefit) {
        benefits.add(benefit);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double calculateTotalBenefitsCost() {

        return CompanyBenefit.calculateTotalCost(benefits.toArray(new CompanyBenefit[0]));
    }

    public double calculateTotalCompensation() {
        return totalCompensationCalculator.apply(baseSalary, calculateTotalBenefitsCost());
    }

    public void setTotalCompensationCalculator(BiFunction<Double, Double, Double> calculator) {
        this.totalCompensationCalculator = calculator;
    }

    public static void processSkills(List<Employee> employees) {
        Set<String> allUniqueSkills = employees.stream()
                .filter(e -> e instanceof Skillable)
                .flatMap(e -> Arrays.stream(((Skillable) e).getSkills()))
                .collect(Collectors.toSet());

        System.out.println("All unique skills: " + allUniqueSkills);
    }
}

