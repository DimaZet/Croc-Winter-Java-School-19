package ru.croc.jws.messager.common;

import java.util.Date;

public class Message {

    private final User author;
    private final String text;
    private final Date timestamp;

    public Message(User author, String text) {
        this.author = author;
        this.text = text;
        this.timestamp = new Date();
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
