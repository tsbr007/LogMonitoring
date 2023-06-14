package com.wellsfargo.logautomation.components;

import java.util.List;

import com.wellsfargo.logautomation.model.Alert;
import com.wellsfargo.logautomation.model.Notification;

public class EscalationService {
    private NotificationService notificationService;
    private List<String> escalationContacts;

    
    
    public EscalationService() {
		super();
	}

	public EscalationService(NotificationService notificationService, List<String> escalationContacts) {
        this.notificationService = notificationService;
        this.escalationContacts = escalationContacts;
    }

    public void escalateAlert(Alert alert) {
        for (String contact : escalationContacts) {
            String message = String.format("Escalation: %s", alert.getMessage());
            Notification notification = new Notification(contact, message);
            notificationService.sendNotification(notification);
        }
    }
}

