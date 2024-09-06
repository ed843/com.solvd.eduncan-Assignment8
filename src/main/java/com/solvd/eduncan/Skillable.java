package com.solvd.eduncan;

public interface Skillable {
    void addSkill(String skill);
    void removeSkill(String skill);
    String[] getSkills();
    boolean hasSkill(String skill) throws SkillNotFoundException;
}
