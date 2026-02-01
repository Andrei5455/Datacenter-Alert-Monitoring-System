package org.example;

public class UserFactory {
    public static User create(String name, String role, String email, String department, String clearanceLevel) {
        return switch (role) {
            case "Operator" -> new Operator(name, role, email, department);
            case "Admin" -> new Admin(name, role, email, department, Integer.parseInt(clearanceLevel));
            default -> throw new IllegalArgumentException("Unknown role");
        };
    }
}
