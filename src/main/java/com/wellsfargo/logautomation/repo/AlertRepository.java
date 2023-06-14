package com.wellsfargo.logautomation.repo;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Severity;

import com.wellsfargo.logautomation.model.Alert;

public class AlertRepository {
    private List<Alert> alerts;

    public AlertRepository() {
        alerts = new ArrayList<>();
    }

    public void addAlert(Alert alert) {
        alerts.add(alert);
    }

    public void removeAlert(Alert alert) {
        alerts.remove(alert);
    }

    public List<Alert> getAllAlerts() {
        return alerts;
    }

    public List<Alert> getAlertsBySeverity(Severity severity) {
        List<Alert> filteredAlerts = new ArrayList<>();

        for (Alert alert : alerts) {
            if (alert.getSeverity() == severity) {
                filteredAlerts.add(alert);
            }
        }

        return filteredAlerts;
    }
    
    public void saveAlerts(List<Alert> alerts) {
        this.alerts.addAll(alerts);
        System.out.println("Alerts saved to the repository: " + alerts.size());
    }
    
    public void clearAlerts() {
        alerts.clear();
    }
}

