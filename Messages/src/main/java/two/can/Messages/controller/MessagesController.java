package two.can.Messages.controller;

import two.can.Messages.model.Message;
import two.can.Messages.service.MessagesService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class MessagesController {
    
    @Autowired
    MessagesService messagesService;

    @RequestMapping(method = RequestMethod.POST, value = "/messages/addConversation")
    @ApiOperation(value = "Adds a new converation to the database")
    public String addConversation(String uniqID) {

        messagesService.addConversation(uniqID);

        return "Message added to Conversation ID " + uniqID;
    }



    @RequestMapping(method = RequestMethod.POST, value = "/messages/addMessage")
    @ApiOperation(value = "Adds a message to a conversation, if the conversation does not exist, it will be created.")
    public String add(String uniqID, @RequestBody Message message) {

        messagesService.addMessage(uniqID, message);

        return "Message added to Conversation ID " + uniqID;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/messages/getMessages")
    @ApiOperation(value = "Gets the last 'n' messages from a conversation.")
    public ArrayList<Message> get(String uniqID, int n) {

        return messagesService.getMessages(uniqID, n);
    }
}