package two.can.Messages.model;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;

public class Messages {

    @Id
    private String uniqID;
    private ArrayList<Message> messages;

    public Messages(){}

    public Messages(String uniqID) {
        this.uniqID = uniqID;
    }

    public Messages(String uniqID, ArrayList<Message> messages) {
        this.uniqID = uniqID;
        this.messages = messages;
    }

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