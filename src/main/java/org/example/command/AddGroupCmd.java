package org.example.command;

import org.example.Command;
import org.example.CommandTools;
import org.example.ResourceGroup;

public class AddGroupCmd implements Command {
    public void execute(String[] tokens, CommandTools tools) {
        ResourceGroup group = new ResourceGroup(tokens[1]);
        tools.database().addResourceGroup(group);
        tools.pw().println("ADD GROUP: " + tokens[1]);
    }
}
