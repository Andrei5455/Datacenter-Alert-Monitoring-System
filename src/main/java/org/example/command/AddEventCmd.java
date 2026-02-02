package org.example.command;

import org.example.Alert;
import org.example.Command;
import org.example.CommandTools;

public class AddEventCmd implements Command {
    public void execute(String[] tokens, CommandTools tools) {
        Alert alert = new Alert(tokens[1], tokens[2], tokens[4], tokens[3]);
        tools.database().addAlert(alert);
        tools.pw().println("ADD EVENT: " + tokens[3] + ": type = " + tokens[1] + " && severity = " + tokens[2] + " && message = " + tokens[4]);
    }
}
