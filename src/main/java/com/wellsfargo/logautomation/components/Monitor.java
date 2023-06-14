package com.wellsfargo.logautomation.components;

import java.io.File;
import java.util.List;

import com.wellsfargo.logautomation.model.Alert;
import com.wellsfargo.logautomation.model.LogEntry;

public class Monitor {
    private LogCollector logCollector;
    private LogParser logParser;
    private RuleEngine ruleEngine;
    private AlertGenerator alertGenerator;
    private EscalationService escalationService;
    private IncidentManagementClient incidentManagementClient;

    public Monitor(LogCollector logCollector, LogParser logParser, RuleEngine ruleEngine,
                   AlertGenerator alertGenerator, EscalationService escalationService,
                   IncidentManagementClient incidentManagementClient) {
        this.logCollector = logCollector;
        this.logParser = logParser;
        this.ruleEngine = ruleEngine;
        this.alertGenerator = alertGenerator;
        this.escalationService = escalationService;
        this.incidentManagementClient = incidentManagementClient;
    }

    public void startMonitoring() {
        List<File> logFiles = logCollector.collectLogs();

        for (File logFile : logFiles) {
            List<LogEntry> logEntries = logParser.parseLogEntries(logFile);
            List<Alert> alerts = ruleEngine.applyRules(logEntries);
            alertGenerator.generateAlerts(alerts);

            for (Alert alert : alerts) {
                if (alert.isEscalationRequired()) {
                    escalationService.escalateAlert(alert);
                }

                if (alert.isIncidentCreationRequired()) {
                    incidentManagementClient.createIncident(alert);
                }
            }
        }
    }
}


