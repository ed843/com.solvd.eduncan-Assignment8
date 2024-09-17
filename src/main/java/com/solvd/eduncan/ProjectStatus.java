package com.solvd.eduncan;

public enum ProjectStatus {
    PLANNING, IN_PROGRESS, TESTING, COMPLETED, ON_HOLD;

    public boolean isActive() {
        return this == IN_PROGRESS || this == TESTING;
    }
}