package org.example;

public class RemoveGroupCmd implements Command{
    public void execute(String[] tokens, CommandTools tools) {
        if (!tools.getDatabase().findGroup(tokens[1]))
            tools.pw().println("REMOVE GROUP: Group not found: ipAddress = " + tokens[1]);
        else {
            tools.pw().println("REMOVE GROUP: " + tokens[1]);
            tools.getDatabase().removeResourceGroup(tokens[1]);
        }
    }
}
