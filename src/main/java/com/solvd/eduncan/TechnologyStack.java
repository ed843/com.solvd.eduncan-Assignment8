package com.solvd.eduncan;

public enum TechnologyStack {
    JAVA("Java", "Backend"),
    PYTHON("Python", "Data Science"),
    JAVASCRIPT("JavaScript", "Frontend"),
    CSHARP("C#", ".NET"),
    GOLANG("Go", "Backend");

    private final String name;
    private final String primaryUse;

    TechnologyStack(String name, String primaryUse) {
        this.name = name;
        this.primaryUse = primaryUse;
    }

    public String getName() { return name; }
    public String getPrimaryUse() { return primaryUse; }
}