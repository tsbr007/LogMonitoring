package com.wellsfargo.logautomation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "alert")
public class AlertConfig {
    private int threshold;
    private String severity;
    private boolean enableEscalation;

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public boolean isEnableEscalation() {
        return enableEscalation;
    }

    public void setEnableEscalation(boolean enableEscalation) {
        this.enableEscalation = enableEscalation;
    }
}

