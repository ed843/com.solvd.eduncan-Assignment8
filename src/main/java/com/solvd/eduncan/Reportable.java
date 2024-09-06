package com.solvd.eduncan;

public interface Reportable {
    String generateReport();
    void exportReport(String format) throws InvalidReportFormatException;
}
