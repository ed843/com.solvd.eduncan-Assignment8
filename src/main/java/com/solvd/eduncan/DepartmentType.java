package com.solvd.eduncan;

public enum DepartmentType {
    HR, IT, FINANCE, MARKETING, OPERATIONS;

    private Manager manager;

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }
}
