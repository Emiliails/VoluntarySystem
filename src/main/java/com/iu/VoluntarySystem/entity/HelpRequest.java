package com.iu.VoluntarySystem.entity;

public class HelpRequest {
    private int helpRequestId;
    private int helpSeekerId;
    private String helpRequestCreateTime;
    private String helpRequestLocation;
    private String helpRequestContent;
    private int volunteerTeamId;

    public int getHelpRequestId() {
        return helpRequestId;
    }

    public void setHelpRequestId(int helpRequestId) {
        this.helpRequestId = helpRequestId;
    }

    public int getHelpSeekerId() {
        return helpSeekerId;
    }

    public void setHelpSeekerId(int helpSeekerId) {
        this.helpSeekerId = helpSeekerId;
    }

    public String getHelpRequestCreateTime() {
        return helpRequestCreateTime;
    }

    public void setHelpRequestCreateTime(String helpRequestCreateTime) {
        this.helpRequestCreateTime = helpRequestCreateTime;
    }

    public String getHelpRequestLocation() {
        return helpRequestLocation;
    }

    public void setHelpRequestLocation(String helpRequestLocation) {
        this.helpRequestLocation = helpRequestLocation;
    }

    public String getHelpRequestContent() {
        return helpRequestContent;
    }

    public void setHelpRequestContent(String helpRequestContent) {
        this.helpRequestContent = helpRequestContent;
    }

    public int getVolunteerTeamId() {
        return volunteerTeamId;
    }

    public void setVolunteerTeamId(int volunteerTeamId) {
        this.volunteerTeamId = volunteerTeamId;
    }
}
