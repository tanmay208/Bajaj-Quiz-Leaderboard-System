package com.srmquiz.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitResponse {
    private boolean isCorrect;
    private boolean isIdempotent;
    private int submittedTotal;
    private int expectedTotal;
    private String message;

    // Getters and Setters
    public boolean getIsCorrect() { return isCorrect; }
    public void setIsCorrect(boolean isCorrect) { this.isCorrect = isCorrect; }
    public boolean getIsIdempotent() { return isIdempotent; }
    public void setIsIdempotent(boolean isIdempotent) { this.isIdempotent = isIdempotent; }
    public int getSubmittedTotal() { return submittedTotal; }
    public void setSubmittedTotal(int submittedTotal) { this.submittedTotal = submittedTotal; }
    public int getExpectedTotal() { return expectedTotal; }
    public void setExpectedTotal(int expectedTotal) { this.expectedTotal = expectedTotal; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public String toString() {
        return "SubmitResponse{" +
                "isCorrect=" + isCorrect +
                ", isIdempotent=" + isIdempotent +
                ", submittedTotal=" + submittedTotal +
                ", expectedTotal=" + expectedTotal +
                ", message='" + message + '\'' +
                '}';
    }
}
