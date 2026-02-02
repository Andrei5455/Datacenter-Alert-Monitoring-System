package org.example;

public class UserFactory {
    public static User create(String name, String role, String email, String department, String clearanceLevel) {
        if (name.isBlank() || role.isBlank())
            throw new UserException("UserException: Name and role can't be empty.");
        else {
            return switch (role) {
                case "Operator" -> new Operator(name, role, email, department);
                case "Admin" -> new Admin(name, role, email, department, Integer.parseInt(clearanceLevel));
                default -> throw new IllegalArgumentException("Unknown role");
            };
        }
    }
}
