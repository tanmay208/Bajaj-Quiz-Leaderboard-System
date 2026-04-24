package com.srmquiz.models;

import java.util.List;

public class SubmitRequest {
    private String regNo;
    private List<ParticipantScore> leaderboard;

    public SubmitRequest(String regNo, List<ParticipantScore> leaderboard) {
        this.regNo = regNo;
        this.leaderboard = leaderboard;
    }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }
    public List<ParticipantScore> getLeaderboard() { return leaderboard; }
    public void setLeaderboard(List<ParticipantScore> leaderboard) { this.leaderboard = leaderboard; }
}
