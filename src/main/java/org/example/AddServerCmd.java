package org.example;

public class AddServerCmd implements Command{
    public void execute(String[] tokens, CommandTools tools) {
        Location location = new Location.Builder(tokens[4]).setCity(tokens[5]).setAddress(tokens[6]).setLatitude(tokens[7]).setLongitude(tokens[8]).build();
        User owner = UserFactory.create(tokens[9], tokens[10], tokens[11], tokens[12], tokens[13]);
        Server server = new Server.Builder(tokens[2], location, owner).setHostName(tokens[1]).setStatus((ServerStatus.valueOf(tokens[3]))).setCpuCores(tokens[14]).setRamGb(tokens[15]).setStorageGb(tokens[16]).build();
        tools.database().addServer(server);
        tools.pw().println("ADD SERVER: " + tokens[2] + ": " + tokens[3]);
    }
}
