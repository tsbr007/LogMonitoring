package com.wellsfargo.logautomation.components;

import java.util.List;

import com.wellsfargo.logautomation.model.Alert;
import com.wellsfargo.logautomation.model.Analyst;
import com.wellsfargo.logautomation.model.Notification;

public class NotificationService {
    private List<Analyst> analysts;

    public NotificationService(List<Analyst> analysts) {
        this.analysts = analysts;
    }
    
    public NotificationService() {
     }

    public void sendNotification(Alert alert) {
        for (Analyst analyst : analysts) {
            String message = buildNotificationMessage(alert, analyst);
            sendNotificationToAnalyst(message, analyst);
        }
    }
    
    public void sendNotification(Notification notification) {
        for (Analyst analyst : analysts) {
            String message = buildNotificationMessage(notification, analyst);
            sendNotificationToAnalyst(message, analyst);
        }
    }

    private String buildNotificationMessage(Alert alert, Analyst analyst) {
        // Build the notification message based on the alert and analyst
        return "Notification for analyst: " + analyst.getName() + "\n"
                + "Title: " + alert.getTitle() + "\n"
                + "Description: " + alert.getDescription();
    }
    
    private String buildNotificationMessage(Notification notification, Analyst analyst) {
        // Build the notification message based on the alert and analyst
        return "Notification for analyst: " + analyst.getName() + "\n"
                  + "Description: " + notification.getMessage();
    }

    private void sendNotificationToAnalyst(String message, Analyst analyst) {
        // Send the notification message to the analyst
        System.out.println("Sending notification to analyst: " + analyst.getName());
        System.out.println("Notification message:\n" + message);
        
    }
    
}



