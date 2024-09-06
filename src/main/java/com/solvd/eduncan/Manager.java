package com.solvd.eduncan;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public final class Manager extends Employee implements Reportable{
    private String availability;
    private String currentTask;
    private PriorityQueue<String> taskPriority;

    public Manager(String employeeId, String name, Department department, String availability) {
        super(employeeId, name, "Manager", department);
        this.availability = availability;
        this.taskPriority = new PriorityQueue<>();
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }


    public void performDuties() {
        System.out.println("Performing managing...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Done!");
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
        if (currentTask.isEmpty()) {
            return "Currently free";
        } else {
            return "Working on " + currentTask + ".";
        }
    }

    public void approveVacation(Employee employee, int days) {
        // Logic to approve vacation
        System.out.println("Vacation approved for " + employee.getName() + " for " + days + " days.");
    }

    @Override
    public String generateReport() {
        return "Generating report for manager " + getEmployeeId() + ".";
    }

    public void exportReport(String format) throws InvalidReportFormatException {
        if(format.equals("pdf") || format.equals("docx") || format.equals("xls") || format.equals("xlsx"))
            System.out.println("Exporting report for project " + getName() + " at " + getDepartment().toString() + " in " + format + " format.");
        else
            throw new InvalidReportFormatException("The report cannot be exported in the given format");
    }

    public void addPriorityTask(String task) {
        taskPriority.offer(task);
    }

    public String getNextPriorityTask() {
        return taskPriority.poll();
    }
}
