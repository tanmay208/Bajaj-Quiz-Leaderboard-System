package com.srmquiz.models;

public class ParticipantScore {
    private String participant;
    private int totalScore;

    public ParticipantScore(String participant, int totalScore) {
        this.participant = participant;
        this.totalScore = totalScore;
    }

    public String getParticipant() { return participant; }
    public void setParticipant(String participant) { this.participant = participant; }
    public int getTotalScore() { return totalScore; }
    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }
}
