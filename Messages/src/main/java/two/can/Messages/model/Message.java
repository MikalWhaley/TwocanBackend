package two.can.Messages.model;

import java.util.Date;

public class Message{

    private Date date;
    private String userID;
    private String messageBody;

    public Message(){}

    public Message(String userID, String messageBody) {
        this.date = new Date();
        this.userID = userID;
        this.messageBody = messageBody;
    }

    public Date getTimeStamp() {
        return this.date;
    }
    
    public String getUserID() {
        return this.userID;
    }

    public String getMessageBody() {
        return this.messageBody;
    }

    public void getTimeStamp(Date date) {
        this.date = date;
    }
    
    public void getUserID(String userID) {
        this.userID = userID;
    }

    public void getMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}