package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ResourceGroup {
    private List<User> members;
    private String ipAddress;

    public ResourceGroup(String ipAddress) {
        if (ipAddress.isBlank())
            throw new MissingIpAddressException("MissingIpAddressException: Server IP Address was not provided.");
        else {
            members = new ArrayList<>();
            this.ipAddress = ipAddress;
        }
    }
    public void addMember(User u) {
        members.add(u);
    }
    public List<User> getMembers() {
        return this.members;
    }
    public String getIpAddress() {
        return this.ipAddress;
    }
    public void removeMember(User target) {
        Iterator<User> it = members.iterator();
        while (it.hasNext()) {
            User u = it.next();
            if (u.getName().equals(target.getName()))
                it.remove();
        }
    }
    public User findMember(String name, String role){
        if (name.isBlank() || role.isBlank())
            throw new UserException("User Exception: Name and role can't be empty.");
        else {
            for (User u : members)
                if (u.getName().equals(name) && u.getRole().equals(role))
                    return u;
            return null;
        }
    }
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ResourceGroup))
            return false;
        ResourceGroup group = (ResourceGroup) o;
        return Objects.equals(this.ipAddress, group.ipAddress);
    }
    public int hashCode() {
        return Objects.hash(ipAddress);
    }
}
