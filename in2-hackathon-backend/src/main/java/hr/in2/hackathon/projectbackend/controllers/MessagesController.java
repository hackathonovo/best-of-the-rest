package hr.in2.hackathon.projectbackend.controllers;

import hr.in2.hackathon.projectbackend.models.DTO.MessageDTO;
import hr.in2.hackathon.projectbackend.models.Message;
import hr.in2.hackathon.projectbackend.repositories.ActionRepository;
import hr.in2.hackathon.projectbackend.repositories.MessageRepository;
import hr.in2.hackathon.projectbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActionRepository actionRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Message getMessage(@RequestBody MessageDTO newMessage){
        Message message = new Message();
        message.setUser(this.userRepository.getOne(newMessage.userId));
        message.setAction(this.actionRepository.getOne(newMessage.actionId));
        message.setMessageText(newMessage.messageText);
        message.setMessageType(newMessage.messageType);
        return this.messageRepository.save(message);
    }

}
