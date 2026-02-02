package org.example;

public enum ServerStatus {
    UP("up"),
    DOWN("down"),
    DEGRADED("degraded");

    private String status;

    ServerStatus (String status) {
        this.status = status;
    }
    String getStatus() {
        return this.status;
    }
}
