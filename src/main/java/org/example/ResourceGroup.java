package org.example;

import java.util.Iterator;
import java.util.List;

public class ResourceGroup {
    private List<User> members;
    private String ipAddress;

    public void addMember(User u) {
        members.add(u);
    }
    public List<User> getMembers() {
        return this.members;
    }
    public void removeMember(User target) {
        Iterator<User> it = members.iterator();
        while (it.hasNext()) {
            User u = it.next();
            if (u.getName().equals(target.getName()))
                it.remove();
        }
    }
}
