package com.solvd.eduncan;

public interface Auditable {
    void startAudit(String date);
    void endAudit(String date);
    String getAuditLog();
    boolean isCompliant();
}
