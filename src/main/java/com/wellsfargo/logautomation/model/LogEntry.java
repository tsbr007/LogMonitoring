package com.wellsfargo.logautomation.model;

import java.time.LocalDateTime;

public class LogEntry {
    private LocalDateTime timestamp;
    private String message;
    private String severity;

    public LogEntry(LocalDateTime timestamp, String message, String severity) {
        this.timestamp = timestamp;
        this.message = message;
        this.severity = severity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getSeverity() {
        return severity;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", severity='" + severity + '\'' +
                '}';
    }
}

