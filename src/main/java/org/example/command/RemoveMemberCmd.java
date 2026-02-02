package org.example.command;

import org.example.Command;
import org.example.CommandTools;
import org.example.ResourceGroup;
import org.example.User;

public class RemoveMemberCmd implements Command {
    public void execute(String[] tokens, CommandTools tools) {
        if (!tools.database().findGroup(tokens[1]))
            tools.pw().println("REMOVE MEMBER: Group not found: ipAddress = " + tokens[1]);
        else {
            ResourceGroup targetGroup = tools.database().getResourceGroup(tokens[1]);
            User targetMember = targetGroup.findMember(tokens[2], tokens[3]);
            if (targetMember != null) {
                tools.pw().println("REMOVE MEMBER: " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
                targetGroup.removeMember(targetMember);
            } else
                tools.pw().println("REMOVE MEMBER: Member not found: ipAddress = " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
        }
    }
}
