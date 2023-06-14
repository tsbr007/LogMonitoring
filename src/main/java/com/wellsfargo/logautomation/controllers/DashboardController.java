package com.wellsfargo.logautomation.controllers;

import java.util.List;

import com.wellsfargo.logautomation.components.RuleEngine;
import com.wellsfargo.logautomation.model.Alert;
import com.wellsfargo.logautomation.model.LogEntry;
import com.wellsfargo.logautomation.repo.AlertRepository;
import com.wellsfargo.logautomation.service.LogAnalyzer;

public class DashboardController {
    private LogAnalyzer logAnalyzer;
    private RuleEngine ruleEngine;
    private static AlertRepository alertRepository; 
    
    

    public DashboardController() {
		super();
	}

	public DashboardController(LogAnalyzer logAnalyzer, RuleEngine ruleEngine, AlertRepository alertRepository) {
        this.logAnalyzer = logAnalyzer;
        this.ruleEngine = ruleEngine;
        this.alertRepository = alertRepository;
    }

    public void displayDashboard() {
        List<Alert> allAlerts = alertRepository.getAllAlerts();
        System.out.println("Dashboard");

        for (Alert alert : allAlerts) {
            System.out.println("Severity: " + alert.getSeverity());
            System.out.println("Message: " + alert.getMessage());
            System.out.println("-------------------------------");
        }
    }
    
    public static void update(List<LogEntry> logEntries, List<Alert> alerts) {
        // Logic to update the dashboard with the provided log entries and alerts
        displayLogEntries(logEntries);
        displayAlerts(alerts);
    }

    private static void displayLogEntries(List<LogEntry> logEntries) {
        // Logic to display the log entries on the dashboard
        System.out.println("Log Entries:");
        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry.toString());
        }
        System.out.println();
    }

    private static void displayAlerts(List<Alert> alerts) {
        // Logic to display the alerts on the dashboard
        System.out.println("Alerts:");
        for (Alert alert : alerts) {
            System.out.println(alert.toString());
        }
        System.out.println();

        // Example: Saving the alerts to the repository
        alertRepository.saveAlerts(alerts);
    }
}

