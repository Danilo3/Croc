package ru.croc.jws.messager.common;

import java.util.Date;

public class Message {

    private final String text;
    private final User author;
    private final Date time;

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public Date getTime() {
        return time;
    }


    public Message(User author, String text){
        this.author = author;
        this.text = text;
        this.time = new Date(); // now
    }

}
