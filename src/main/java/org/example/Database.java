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
    public void addResourceGroups(Set<ResourceGroup> groupCollection) {
        resourceGroups.addAll(groupCollection);
    }
    public void addAlert(Alert a) {
        alerts.add(a);
    }
}
