package org.example;

public class AddGroupCmd implements Command{
    public void execute(String[] tokens, CommandTools tools) {
        ResourceGroup group = new ResourceGroup(tokens[1]);
        tools.getDatabase().addResourceGroup(group);
        tools.pw().println("ADD GROUP: " + tokens[1]);
    }
}
