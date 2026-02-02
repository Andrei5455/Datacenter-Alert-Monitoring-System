package org.example;

public class Alert {

    private AlertType type;
    private Severity severity;
    private String message;
    private String ipAddress;

    public Alert(String type, String severity, String message, String ipAddress) {
        this.type = AlertType.valueOf(type);
        this.severity = Severity.valueOf(severity);
        this.message = message;
        this.ipAddress = ipAddress;
    }
}
