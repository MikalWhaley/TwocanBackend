package two.can.Messages.model;

import java.util.ArrayList;

public class Messages {

    private String uniqID;
    private ArrayList<Message> messages;

    public Messages(){}

    public String getUniqID() {
        return this.uniqID;
    }

    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    public void setUniqID(String uniqID) {
        this.uniqID = uniqID;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}