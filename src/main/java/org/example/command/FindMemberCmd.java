package org.example.command;

import org.example.Command;
import org.example.CommandTools;
import org.example.ResourceGroup;

public class FindMemberCmd implements Command {
    public void execute(String[] tokens, CommandTools tools) {
        if (!tools.database().findGroup(tokens[1]))
            tools.pw().println("FIND MEMBER: Group not found: ipAddress = " + tokens[1]);
        else {
            ResourceGroup targetGroup = tools.database().getResourceGroup(tokens[1]);
            if (targetGroup.findMember(tokens[2], tokens[3]) != null)
                tools.pw().println("FIND MEMBER: " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
            else
                tools.pw().println("FIND MEMBER: Member not found: ipAddress = " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
        }
    }
}
