package com.wellsfargo.logautomation.components;

import java.util.List;

import com.wellsfargo.logautomation.model.Alert;

public class AlertGenerator {
    private NotificationService notificationService;

    
    
    public AlertGenerator() {
		super();
	}

	public AlertGenerator(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void generateAlerts(List<Alert> alerts) {
        for (Alert alert : alerts) {
            notificationService.sendNotification(alert);
        }
    }
}

