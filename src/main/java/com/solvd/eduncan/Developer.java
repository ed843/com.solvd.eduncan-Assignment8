package com.solvd.eduncan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Developer extends Employee implements Skillable, Billable {
    private final List<String> skills;
    private String currentTask = "";
    private List<TechnologyStack> techStack;


    public Developer(String name, EmployeeLevel employeeLevel,
                     Department department, List<String> programmingLanguages, double baseSalary, int yearsOfExperience) {
        super(name, employeeLevel, department, baseSalary, yearsOfExperience);
        this.skills = programmingLanguages;
        this.techStack = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Developer{programmingLanguages=" + Arrays.toString(skills.toArray()) + ", " + super.toString() + "}";

    }

    @Override
    public int hashCode() {
        return super.hashCode() + Arrays.hashCode(skills.toArray());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Developer developer = (Developer) obj;
        return Arrays.equals(skills.toArray(), developer.skills.toArray());
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
        return 35;
    }

    @Override
    public double getTotalCost() {
        return 40 * 35;
    }

    public void addTechnology(TechnologyStack tech) {
        techStack.add(tech);
    }

    public static List<String> getCommonSkills(List<Developer> developers) {

        return developers.stream()
                // Flatten the stream of skill arrays into a stream of individual skills
                .flatMap(d -> Arrays.stream(d.getSkills()))
                // Group skills by their name, counting occurrences
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                // Convert the resulting map back to a stream of map entries
                .entrySet().stream()
                // Keep only skills that appear as many times as there are developers
                // (meaning all developers have this skill)
                .filter(entry -> entry.getValue() == developers.size())
                // Extract just the skill name from each remaining entry
                .map(Map.Entry::getKey)
                // Collect the common skill names into a list
                .collect(Collectors.toList());
    }

    public List<TechnologyStack> getTechStack() {
        return new ArrayList<>(techStack);
    }
}
