package com.wellsfargo.logautomation.service;

import java.io.File;
import java.util.List;

import com.wellsfargo.logautomation.components.AlertGenerator;
import com.wellsfargo.logautomation.components.EscalationService;
import com.wellsfargo.logautomation.components.LogCollector;
import com.wellsfargo.logautomation.components.LogParser;
import com.wellsfargo.logautomation.components.NotificationService;
import com.wellsfargo.logautomation.components.RuleEngine;
import com.wellsfargo.logautomation.controllers.DashboardController;
import com.wellsfargo.logautomation.model.Alert;
import com.wellsfargo.logautomation.model.LogEntry;
import com.wellsfargo.logautomation.model.RuleResult;

public class LogAnalyzer {
    private LogCollector logCollector;
    private LogParser logParser;
    private RuleEngine ruleEngine;
    private AlertGenerator alertGenerator;
    private NotificationService notificationService;
    private EscalationService escalationService;
    private DashboardController dashboardController;

    public LogAnalyzer() {
        logCollector = new LogCollector();
        logParser = new LogParser();
        ruleEngine = new RuleEngine();
        alertGenerator = new AlertGenerator();
        notificationService = new NotificationService();
        escalationService = new EscalationService();
        dashboardController = new DashboardController();
    }

    public void analyzeLogs() {
        // Collect logs from the server
        List<File> logLines = logCollector.collectLogs(); 

        // Parse the log lines into LogEntry objects
        List<LogEntry> logEntries = logParser.parseLogEntriesFiles(logLines);

        // Apply rule-based analysis to the log entries
        List<Alert> alerts = ruleEngine.applyRules(logEntries);

        // Generate alerts based on the rule results
        alertGenerator.generateAlerts(alerts);

        // Update the dashboard with the latest log analysis results
        updateDashboard(logEntries, alerts);
    }
    
    

    private void updateDashboard(List<LogEntry> logEntries, List<Alert> alerts) {
        dashboardController.update(logEntries, alerts);
    }
}

