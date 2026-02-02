package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Database {
    private static Database instance;
    private Set<Server> servers;
    private Set<ResourceGroup> resourceGroups;
    private Set<Alert> alerts;

    private Database() {
        servers = new HashSet<>();
        resourceGroups = new HashSet<>();
        alerts = new HashSet<>();
    }
    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }
    public void addServer(Server s) {
        servers.add(s);
    }
    public void addServers(Set<Server> serverColection) {
        servers.addAll(serverColection);
    }
    public void addResourceGroup(ResourceGroup g) {
        resourceGroups.add(g);
    }
    public void removeResourceGroup(String ipAddress) {
        if (ipAddress.isBlank())
            throw new MissingIpAddressException("MissingIpAddressException: Server IP Address was not provided.");
        else
            resourceGroups.remove(new ResourceGroup(ipAddress));
    }
    public void addResourceGroups(Set<ResourceGroup> groupCollection) {
        resourceGroups.addAll(groupCollection);
    }
    public void addAlert(Alert a) {
        alerts.add(a);
    }
    public Boolean findGroup(String ipAddress) {
        if (ipAddress.isBlank())
            throw new MissingIpAddressException("MissingIpAddressException: Server IP Address was not provided.");
        else
            return resourceGroups.contains(new ResourceGroup(ipAddress));
    }
    public ResourceGroup getResourceGroup(String ipAddress) {
        for (ResourceGroup group : resourceGroups)
            if (group.getIpAddress().equals(ipAddress))
                return group;
        return null;
    }
}
