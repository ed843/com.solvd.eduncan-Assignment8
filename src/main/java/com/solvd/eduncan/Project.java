package com.solvd.eduncan;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;

public class Project implements Manageable, Auditable, Reportable, Billable {
    private final String projectId;
    private String projectName;
    private double budget;
    private static String auditLog;
    private String currentTask;
    private CustomLinkedList<String> taskList;

    public Project(String projectId, String projectName, double budget) {
        this.projectId = projectId;
        this.projectName = projectName;
        if (budget < 0) throw new NegativeBudgetException("Budget cannot be negative");
        this.budget = budget;
        this.taskList = new CustomLinkedList<>();
    }

    @Override
    public String toString() {
        return "Project{projectId='" + projectId + "', projectName='" + projectName + "', budget=" + budget + "}";
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String newProjectName) {
        this.projectName = newProjectName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double newBudget) {
        this.budget = newBudget;
    }

    @Override
    public void startAudit(String date) {
        auditLog += "\nProject " + projectId + " started at " + date;
        LoggerUtil.log(Level.INFO, "Audit started for project " + projectId + " on " + date);
    }

    @Override
    public void endAudit(String date) {
        auditLog += "\nProject " + projectId + " finished at " + date;
        LoggerUtil.log(Level.INFO, "Audit ended for project " + projectId + " on " + date);
    }

    @Override
    public String getAuditLog() {
        return auditLog;
    }

    @Override
    public String generateReport() {
        return "Generating report for project " + projectId + " at " + projectName;
    }

    @Override
    public void exportReport(String format) throws InvalidReportFormatException {
        if(format.equals("pdf") || format.equals("docx") || format.equals("xls") || format.equals("xlsx"))
            System.out.println("Exporting report for project " + projectId + " at " + projectName + " in " + format + " format.");
        else
            throw new InvalidReportFormatException("The report cannot be exported in the given format '" + format + "'");
    }

    public void writeProjectDetailsToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Project ID: " + projectId);
            writer.newLine();
            writer.write("Project Name: " + projectName);
            writer.newLine();
            writer.write("Budget: " + budget);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    @Override
    public boolean isCompliant() {
        return false;
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

    @Override
    public double calculateBillableHours() {
        return 30;
    }

    @Override
    public double getHourlyRate() {
        return 200;
    }

    @Override
    public double getTotalCost() {
        return 200 * 30;
    }

    public void addTask(String task) {
        taskList.add(task);
    }

    public String getTask(int index) {
        return taskList.get(index);
    }

    public void removeTask(int index) {
        taskList.remove(index);
    }

    public int getTaskCount() {
        return taskList.size();
    }
}

