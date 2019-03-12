package ru.croc.jws.messager.common;

public class Chat {

    private String name;

    public Chat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(Message message) {
        //TODO
    }
}
