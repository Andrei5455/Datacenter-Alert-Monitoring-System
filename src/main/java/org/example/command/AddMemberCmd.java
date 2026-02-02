package org.example.command;

import org.example.*;

public class AddMemberCmd implements Command {
    public void execute(String[] tokens, CommandTools tools) {
        if (!tools.database().findGroup(tokens[1]))
            tools.pw().println("ADD MEMBER: Group was not found: ipAddress = " + tokens[1]);
        else {
            ResourceGroup targetGroup = tools.database().getResourceGroup(tokens[1]);
            User member = UserFactory.create(tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
            targetGroup.addMember(member);
            tools.pw().println("ADD MEMBER: " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
        }
    }
}
