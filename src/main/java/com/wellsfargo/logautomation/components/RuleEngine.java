package com.wellsfargo.logautomation.components;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.logautomation.model.Alert;
import com.wellsfargo.logautomation.model.LogEntry;
import com.wellsfargo.logautomation.model.Rule;
import com.wellsfargo.logautomation.model.RuleResult;

public class RuleEngine {
    private List<Rule> rules;

    public RuleEngine() {
        rules = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void removeRule(Rule rule) {
        rules.remove(rule);
    }

    public List<RuleResult> applyRulesResult(List<LogEntry> logEntries) {
        List<RuleResult> ruleResults = new ArrayList<>();

        for (LogEntry logEntry : logEntries) {
            for (Rule rule : rules) {
                if (rule.matches(logEntry)) {
                    RuleResult ruleResult = new RuleResult(logEntry, rule);
                    ruleResults.add(ruleResult);
                    break;
                }
            }
        }

        return ruleResults;
    }
    
    public List<Alert> applyRules(List<LogEntry> logEntries) {
        List<Alert> alerts = new ArrayList<>();

        for (LogEntry logEntry : logEntries) {
            for (Rule rule : rules) {
                if (rule.matches(logEntry)) {
                    Alert alert = new Alert(rule.getSeverity(), logEntry.getMessage());
                    alerts.add(alert);
                    break; // No need to continue checking other rules
                }
            }
        }

        return alerts;
    }
    
    public List<Alert> applyRules(LogEntry logEntry) {
        List<Alert> alerts = new ArrayList<>();

        for (Rule rule : rules) {
                if (rule.matches(logEntry)) {
                    Alert alert = new Alert(rule.getSeverity(), logEntry.getMessage());
                    alerts.add(alert);
                    break; // No need to continue checking other rules
                }
            }
        

        return alerts;
    }
}



