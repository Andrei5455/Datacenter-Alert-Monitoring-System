package org.example;

public interface Command {
    void execute(String[] tokens, CommandTools tools);
}
