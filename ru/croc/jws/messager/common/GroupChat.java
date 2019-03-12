package ru.croc.jws.messager.common;

import java.util.List;

public class GroupChat extends Chat {

    private List<User> users;

    public GroupChat(String name) {
        super(name);
    }

    public void addUser(User user) {
        if (!users.contains(user))
            users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
