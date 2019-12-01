package two.can.Messages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import two.can.Messages.model.Messages;
import two.can.Messages.repository.MessagesRepository;

@Service
public class MessagesService {

    
    @Autowired
    MessagesRepository messagesRepository;


    public Messages add(Messages messages) {
        
        return messagesRepository.insert(messages);
    }
}