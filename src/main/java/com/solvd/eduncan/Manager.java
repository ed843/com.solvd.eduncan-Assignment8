package com.solvd.eduncan;

import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public final class Manager extends Employee implements Reportable{
    private String availability;
    private String currentTask;
    private PriorityQueue<String> taskPriority;
    private List<Employee> teamMembers;

    public Manager(String name, Department department,
                   String availability, double baseSalary, int yearsOfExperience, List<Employee> teamMembers) {
        super(name, EmployeeLevel.MANAGER, department, baseSalary, yearsOfExperience);
        this.availability = availability;
        this.taskPriority = new PriorityQueue<>();
        this.teamMembers = teamMembers;
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

    public void addTeamMember(Employee employee) {
        teamMembers.add(employee);
    }

    public void removeTeamMember(Employee employee) {
        teamMembers.remove(employee);
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
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

    public double calculateTeamEfficiency(List<Employee> teamMembers) {
        // Good practice: Using streams for calculations
        return teamMembers.stream()
                .mapToDouble(e -> e.getYearsOfExperience() * e.getEmployeeLevel().getLevel())
                .average()
                .orElse(0.0);
    }

    public void addPriorityTask(String task) {
        taskPriority.offer(task);
    }

    public String getNextPriorityTask() {
        return taskPriority.poll();
    }

    public void assignTasksRandomly(List<String> tasks) {
        // Bad practice: Using streams for random assignment (side effects)
        IntStream.range(0, tasks.size())
                .forEach(i -> {
                    int randomIndex = (int) (Math.random() * teamMembers.size());
                    teamMembers.get(randomIndex).assignTask(tasks.get(i));
                });
        // Better approach: Use traditional loop or Collections.shuffle
    }
}
