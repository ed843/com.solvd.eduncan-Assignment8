package com.solvd.eduncan;

public class DepartmentLimitExceededException extends RuntimeException {
    public DepartmentLimitExceededException(String message) {
        super(message);
    }
}