package org.example;

public class CommandFactory {
    public static Command create(String cmdName) {
        return switch (cmdName) {
            case "ADD SERVER" -> new AddServerCmd();
            case "ADD GROUP" -> new AddGroupCmd();
            case "FIND GROUP" -> new FindGroupCmd();
            case "REMOVE GROUP" -> new RemoveGroupCmd();
            case "ADD MEMBER" -> new AddMemberCmd();
            case "FIND MEMBER" -> new FindMemberCmd();
            case "REMOVE MEMBER" -> new RemoveMemberCmd();
            case "ADD EVENT" -> new AddEventCmd();
            default -> null;
        };
    }
    private CommandFactory(){}
}
