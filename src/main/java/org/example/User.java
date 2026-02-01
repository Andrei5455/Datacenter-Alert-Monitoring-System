package org.example;

public abstract class User {
    private String name;
    private String role;
    private String email;

    public User(String name, String role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
    }
    public User() {}
    public String getName() {
        return this.name;
    }
}
