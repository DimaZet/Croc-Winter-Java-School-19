package ru.croc.jws.messager.server;

import ru.croc.jws.messager.common.Chat;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private List<Chat> chats = new ArrayList<>();

    public List<Chat> getChats() {
        return chats;
    }
}
