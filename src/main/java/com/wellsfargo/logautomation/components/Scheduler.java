package com.wellsfargo.logautomation.components;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.wellsfargo.logautomation.model.Alert;
import com.wellsfargo.logautomation.model.LogEntry;

public class Scheduler {
    private RuleEngine ruleEngine;
    private LogCollector logCollector;
    private int interval;

    public Scheduler(RuleEngine ruleEngine, LogCollector logCollector, int interval) {
        this.ruleEngine = ruleEngine;
        this.logCollector = logCollector;
        this.interval = interval;
    }

    public void start() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(() -> {
            // Collect logs
            List<File> logFiles = logCollector.collectLogs();

            // Process each log file
            for (File logFile : logFiles) {
                // Parse log entries from file
                List<LogEntry> logEntries = LogParser.parseLogEntries(logFile);

                // Apply rules and generate alerts
                for (LogEntry logEntry : logEntries) {
                    List<Alert> alerts = ruleEngine.applyRules(logEntry);

                    // Generate and send alerts
                    AlertGenerator alertGenerator = new AlertGenerator(new NotificationService());
                    alertGenerator.generateAlerts(alerts);
                }
            }
        }, 0, interval, TimeUnit.SECONDS);
    }
}


