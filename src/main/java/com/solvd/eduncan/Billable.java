package com.solvd.eduncan;

public interface Billable {
    double calculateBillableHours();
    double getHourlyRate();
    double getTotalCost();
}
