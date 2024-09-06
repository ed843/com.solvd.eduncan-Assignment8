package com.solvd.eduncan;

public class NegativeBudgetException extends IllegalArgumentException {
    public NegativeBudgetException(String message) {
        super(message);
    }
}
