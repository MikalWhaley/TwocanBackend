package two.can.Messages.model;

import java.sql.Timestamp;

public class Message{

    private Timestamp timeStamp;
    private String userID;
    private String messageBody;

    public Message(){}

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }
    
    public String getUserID() {
        return this.userID;
    }

    public String getMessageBody() {
        return this.messageBody;
    }

    public void getTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    public void getUserID(String userID) {
        this.userID = userID;
    }

    public void getMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}