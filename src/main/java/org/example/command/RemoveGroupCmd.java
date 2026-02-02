package org.example.command;

import org.example.Command;
import org.example.CommandTools;

public class RemoveGroupCmd implements Command {
    public void execute(String[] tokens, CommandTools tools) {
        if (!tools.database().findGroup(tokens[1]))
            tools.pw().println("REMOVE GROUP: Group not found: ipAddress = " + tokens[1]);
        else {
            tools.pw().println("REMOVE GROUP: " + tokens[1]);
            tools.database().removeResourceGroup(tokens[1]);
        }
    }
}
