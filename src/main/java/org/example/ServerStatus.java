package org.example;

public enum ServerStatus {
    UP("UP"),
    DOWN("DOWN"),
    DEGRADED("DEGRADED");

    private String status;

    ServerStatus (String status) {
        this.status = status;
    }
    String getStatus() {
        return this.status;
    }
}
