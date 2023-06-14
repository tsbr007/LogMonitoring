package com.wellsfargo.logautomation.model;

import javax.print.attribute.standard.Severity;

public class Notification {
    private String message;
    private String recipient;
    private Severity severity;

    public Notification(String message, String recipient, Severity severity) {
        this.message = message;
        this.recipient = recipient;
        this.severity = severity;
    }
    
    public Notification(String recipient, String message) {
        this.message = message;
        this.recipient = recipient;
       
    }

    public String getMessage() {
        return message;
    }

    public String getRecipient() {
        return recipient;
    }

    public Severity getSeverity() {
        return severity;
    }
}

