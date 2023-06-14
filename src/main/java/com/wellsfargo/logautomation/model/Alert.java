package com.wellsfargo.logautomation.model;

import javax.print.attribute.standard.Severity;

public class Alert {
    private String title;
    private String description;
    private Severity severity;
    private boolean escalationRequired;
    private boolean incidentCreationRequired;
    private String message;

    public Alert(String title, String description, Severity severity) {
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.escalationRequired = false;
        this.incidentCreationRequired = false;
    }
    
    public Alert(Severity severity, String message) {
        this.severity = severity;
        this.message = message;
    }
    
    public Alert(String message, Severity severity) {
        this.message = message;
        this.severity = severity;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    

    public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEscalationRequired() {
        return escalationRequired;
    }

    public boolean isIncidentCreationRequired() {
        return incidentCreationRequired;
    }

    public void setEscalationRequired(boolean escalationRequired) {
        this.escalationRequired = escalationRequired;
    }

    public void setIncidentCreationRequired(boolean incidentCreationRequired) {
        this.incidentCreationRequired = incidentCreationRequired;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", severity='" + severity + '\'' +
                ", escalationRequired=" + escalationRequired +
                ", incidentCreationRequired=" + incidentCreationRequired +
                '}';
    }
}

