package com.solvd.eduncan;

public enum EmployeeLevel {
    INTERN(0, "Intern Developer"),
    JUNIOR(1, "Junior Developer"),
    INTERMEDIATE(2, "Intermediate Developer"),
    SENIOR(3, "Senior Developer"),
    LEAD(4, "Team Lead"),
    MANAGER(5, "Manager"),
    JUNIOR_TESTER(6, "Junior Tester"),
    INTERMEDIATE_TESTER(7, "Intermediate Tester"),
    SENIOR_TESTER(8, "Senior Tester"),
    TEST_LEAD(9, "Test Lead"),
    QA_MANAGER(10, "QA Manager");

    private final int level;
    private final String title;

    EmployeeLevel(int level, String title) {
        this.level = level;
        this.title = title;
    }

    public int getLevel() { return level; }
    public String getTitle() { return title; }

    public double calculateBonus(double baseSalary) {
        return baseSalary * (level * 0.05);
    }
}
