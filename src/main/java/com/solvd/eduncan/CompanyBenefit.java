package com.solvd.eduncan;

public enum CompanyBenefit {
    HEALTH_INSURANCE(1000, "Health Insurance"),
    RETIREMENT_PLAN(500, "401(k) Plan"),
    PAID_TIME_OFF(0, "PTO"),
    GYM_MEMBERSHIP(50, "Gym Membership"),
    EDUCATION_REIMBURSEMENT(2000, "Education Reimbursement");

    private final int annualCost;
    private final String description;

    CompanyBenefit(int annualCost, String description) {
        this.annualCost = annualCost;
        this.description = description;
    }

    public int getAnnualCost() { return annualCost; }
    public String getDescription() { return description; }

    public static int calculateTotalCost(CompanyBenefit... benefits) {
        int total = 0;
        for (CompanyBenefit benefit : benefits) {
            total += benefit.getAnnualCost();
        }
        return total;
    }
}
