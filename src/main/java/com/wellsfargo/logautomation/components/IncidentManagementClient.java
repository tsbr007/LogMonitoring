package com.wellsfargo.logautomation.components;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.wellsfargo.logautomation.model.Alert;
import com.wellsfargo.logautomation.model.JsonObject;

public class IncidentManagementClient {
    private String apiUrl;
    private HttpClient httpClient;

    public IncidentManagementClient(String apiUrl) {
        this.apiUrl = apiUrl;
        this.httpClient = HttpClient.newBuilder().build();
    }

    public void createIncident(Alert alert) {
        // Prepare the incident payload
        String payload = prepareIncidentPayload(alert);

        // Send a POST request to the incident management API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl + "/incidents"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 201) {
                System.out.println("Incident created successfully");
            } else {
                System.out.println("Failed to create incident. Response code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error creating incident: " + e.getMessage());
        }
    }

    private String prepareIncidentPayload(Alert alert) {
        // Prepare the incident payload based on the alert information
        // Convert the alert object to JSON or any other suitable format

        // Example JSON payload:
        JsonObject payload = new JsonObject();
        payload.addProperty("title", alert.getTitle());
        payload.addProperty("description", alert.getDescription());
        // Add more properties as needed

        return payload.toString();
    }
}


