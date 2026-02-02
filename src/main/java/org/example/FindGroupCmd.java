package org.example;

public class FindGroupCmd implements Command{
    public void execute(String[] tokens, CommandTools tools) {
        if (tools.getDatabase().findGroup(tokens[1]))
            tools.pw().println("FIND GROUP: " + tokens[1]);
        else tools.pw().println("FIND GROUP: Group not found: ipAddress = " + tokens[1]);
    }
}
