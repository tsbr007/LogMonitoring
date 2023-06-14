package com.wellsfargo.logautomation.model;

import javax.print.attribute.standard.Severity;

public class Rule {
    private String keyword;
    private Severity severity;

    public Rule(String keyword, Severity severity) {
        this.keyword = keyword;
        this.severity = severity;
    }

    public String getKeyword() {
        return keyword;
    }

    public Severity getSeverity() {
        return severity;
    }

    public boolean matches(LogEntry logEntry) {
        // Logic to check if the log entry matches the rule
        // Here, we check if the log entry message contains the keyword
        return logEntry.getMessage().contains(keyword);
    }
}


