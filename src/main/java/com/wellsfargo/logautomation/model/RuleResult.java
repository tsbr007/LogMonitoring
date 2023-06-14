package com.wellsfargo.logautomation.model;

public class RuleResult {

	
    private LogEntry logEntry;
    private Rule rule;

    public RuleResult(LogEntry logEntry, Rule rule) {
        this.logEntry = logEntry;
        this.rule = rule;
    }

    public LogEntry getLogEntry() {
        return logEntry;
    }

    public Rule getRule() {
        return rule;
    }

    @Override
    public String toString() {
        return "RuleResult{" +
                "logEntry=" + logEntry +
                ", rule=" + rule +
                '}';
    }
}


