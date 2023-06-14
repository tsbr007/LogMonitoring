package com.wellsfargo.logautomation.model;

public class IncidentTicket {
    private String title;
    private String description;
    private String assignedTo;
    private boolean resolved;

    public IncidentTicket(String title, String description) {
        this.title = title;
        this.description = description;
        this.assignedTo = "";
        this.resolved = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void resolve() {
        this.resolved = true;
    }

    @Override
    public String toString() {
        return "IncidentTicket{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", resolved=" + resolved +
                '}';
    }
}


