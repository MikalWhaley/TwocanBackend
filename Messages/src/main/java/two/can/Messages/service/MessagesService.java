package two.can.Messages.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import two.can.Messages.model.Message;
import two.can.Messages.model.Messages;
import two.can.Messages.repository.MessagesRepository;

@Service
public class MessagesService {

    
    @Autowired
    MessagesRepository messagesRepository;


    public Messages addConversation(String uniqID) {
        
        Messages messages = new Messages(uniqID);

        return messagesRepository.insert(messages);
    }


    public void addMessage(String uniqID, String userID, String text) {

        Message message = new Message(userID, text);

        Optional<Messages> temp = messagesRepository.findById(uniqID);

        if(temp.isPresent()) {

            Messages dbConv = temp.get();
            dbConv.getMessages().add(message);
            messagesRepository.save(dbConv);

        } else {

            ArrayList<Message> messageList = new ArrayList<>();
            messageList.add(message);
            Messages conv = new Messages(uniqID, messageList);
            messagesRepository.insert(conv);
        }
    }

    
    public ArrayList<Message> getMessages(String uniqID, int n) {

        Optional<Messages> temp = messagesRepository.findById(uniqID);

        if(temp.isPresent()) {

            Messages dbConv = temp.get();
            ArrayList<Message> dbMessages = dbConv.getMessages();
            int size = dbMessages.size();
            
            if(n >= size) {

                return dbMessages;
            
            } else {

                return new ArrayList<>(dbMessages.subList(size - n, size));
            }
        }

        return new ArrayList<Message>();
    }
}