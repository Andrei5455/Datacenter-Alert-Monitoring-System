package org.example;

public class Operator extends User{

    private String departament;

    public Operator(String name, String role, String email, String department) {
        super(name, role, email);
        this.departament = department;
    }
}
