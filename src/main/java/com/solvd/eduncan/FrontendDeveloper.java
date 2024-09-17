package com.solvd.eduncan;

import java.util.List;

public final class FrontendDeveloper extends Developer {
    private String[] frontendFrameworks;

    public FrontendDeveloper(String name, Department department,
                             EmployeeLevel employeeLevel, List<String> programmingLanguages,
                             String[] frontendFrameworks, double baseSalary) {
        super(name, employeeLevel, department, programmingLanguages, baseSalary);
        this.frontendFrameworks = frontendFrameworks;
    }

    public String[] getFrontendFrameworks() {
        return frontendFrameworks;
    }

    public void setFrontendFrameworks(String[] frontendFrameworks) {
        this.frontendFrameworks = frontendFrameworks;
    }

    @Override
    public void performDuties() {
        System.out.println("Performing frontend duties");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Done!");
    }
}
