package org.example;

public class RemoveMemberCmd implements Command {
    public void execute(String[] tokens, CommandTools tools) {
        if (!tools.getDatabase().findGroup(tokens[1]))
            tools.pw().println("REMOVE MEMBER: Group not found: ipAddress = " + tokens[1]);
        else {
            ResourceGroup targetGroup = tools.getDatabase().getResourceGroup(tokens[1]);
            User targetMember = targetGroup.findMember(tokens[2], tokens[3]);
            if (targetMember != null) {
                tools.pw().println("REMOVE MEMBER: " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
                targetGroup.removeMember(targetMember);
            } else {
                tools.pw().println("REMOVE MEMBER: Member not found: ipAddress = " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
            }
        }
    }
}
