package com.solvd.eduncan;

import java.util.ArrayList;
import java.util.List;

public final class Tester extends Employee implements Skillable, Billable {
    private final String testingTools;
    private final List<String> skills = new ArrayList<String>();
    private String currentTask = "";

    public Tester(String employeeId, String name, Department department, String testingTools) {
        super(employeeId, name, "Tester", department);
        this.testingTools = testingTools;
    }

    public void performDuties() {
        System.out.println("Performing coding...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Done!");
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
    public boolean hasSkill(String skill) throws SkillNotFoundException {
        return skills.contains(skill);
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
        return 40;
    }

    @Override
    public double getHourlyRate() {
        return 25;
    }

    @Override
    public double getTotalCost() {
        return 40 * 25;
    }
}
