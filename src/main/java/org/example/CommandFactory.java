package org.example;

public class CommandFactory {
    public static Command create(String cmdName) {
        switch (cmdName) {
            case "ADD SERVER":
                return new AddServerCmd();
            case "ADD GROUP":
                return new AddGroupCmd();
            case "FIND GROUP":
                return new FindGroupCmd();
            case "REMOVE GROUP":
                return new RemoveGroupCmd();
            case "ADD MEMBER":
                return new AddMemberCmd();
            case "FIND MEMBER":
                return new FindMemberCmd();
            case "REMOVE MEMBER":
                return new RemoveMemberCmd();
            case "ADD EVENT":
                return new AddEventCmd();
            default:
                return null;
        }
    }
    private CommandFactory(){}
}
