package com.solvd.eduncan;

import java.util.ArrayList;
import java.util.List;

public final class Intern extends Employee implements Skillable, Billable {
    private String schoolName;
    private String major;
    private List<String> skills = new ArrayList<String>();
    private String currentTask;

    public Intern(String employeeId, String name, Department department, String schoolName, String major) {
        super(employeeId, name, "Intern", department);
        this.schoolName = schoolName;
        this.major = major;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void performDuties() {
        System.out.println("Performing interning...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("CrowdStrike Patch Done!");
    }

    @Override
    public String toString() {
        return "Intern{schoolName='" + schoolName + "', major='" + major + "', " + super.toString() + "}";
    }

    @Override
    public void addSkill(String skill) {
        skills.add(skill);
    }

    @Override
    public void removeSkill(String skill) {
        try {
            if (!skills.contains(skill)) {
                throw new SkillNotFoundException("Skill not found: " + skill);
            }
            skills.remove(skill);
        } catch (SkillNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String[] getSkills() {
        return skills.toArray(new String[skills.size()]);
    }

    @Override
    public boolean hasSkill(String skill) {
        return skills.contains(skill);
    }

    @Override
    public double calculateBillableHours() {
        return 20;
    }

    @Override
    public double getHourlyRate() {
        return 15.50;
    }

    @Override
    public double getTotalCost() {
        return 15.50 * 20;
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
}
