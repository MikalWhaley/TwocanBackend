package two.can.Messages.controller;

import two.can.Messages.model.Messages;
import two.can.Messages.service.MessagesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class MessagesController {
    
    @Autowired
    MessagesService messagesService;

    @RequestMapping(method = RequestMethod.POST, value = "/messages/add")
    @ApiOperation(value = "Adds a new converation to the database")
    public String add(@RequestBody Messages messages) {

        messagesService.add(messages);

        return "Conversation ID " + messages.getUniqID() + " added Successfully";
    }
}