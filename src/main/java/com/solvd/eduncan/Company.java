package com.solvd.eduncan;

import java.lang.reflect.*;
import java.util.*;
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

    public static void reflectionDemo() {
        try {
            // Get the Class object for Company
            Class<?> companyClass = Company.class;

            System.out.println("Class name: " + companyClass.getName());

            // Extract information about fields
            System.out.println("\nFields:");
            Field[] fields = companyClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Name: " + field.getName());
                System.out.println("Type: " + field.getType().getSimpleName());
                System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
                System.out.println();
            }

            // Extract information about constructors
            System.out.println("Constructors:");
            Constructor<?>[] constructors = companyClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Name: " + constructor.getName());
                System.out.println("Parameter types: " + Arrays.toString(constructor.getParameterTypes()));
                System.out.println("Modifiers: " + Modifier.toString(constructor.getModifiers()));
                System.out.println();
            }

            // Extract information about methods
            System.out.println("Methods:");
            Method[] methods = companyClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Name: " + method.getName());
                System.out.println("Return type: " + method.getReturnType().getSimpleName());
                System.out.println("Parameter types: " + Arrays.toString(method.getParameterTypes()));
                System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
                System.out.println();
            }

            // Create object using reflection
            Constructor<?> constructor = companyClass.getConstructor(String.class, String.class);
            Object companyObject = constructor.newInstance("ReflectionCorp", "Reflection City");

            // Call method using reflection
            Method addDepartmentMethod = companyClass.getMethod("addDepartment", Department.class);
            Department itDepartment = new Department("IT", "Tech Building", DepartmentType.IT);
            addDepartmentMethod.invoke(companyObject, itDepartment);

            // Verify the method call
            Method getDepartmentsMethod = companyClass.getMethod("getDepartments");
            List<Department> departments = (List<Department>) getDepartmentsMethod.invoke(companyObject);
            System.out.println("Departments after reflection call: " + departments);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public int getEmployeeCount() {
        return employees.size();
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
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

