package hr.in2.hackathon.projectbackend.controllers;


import hr.in2.hackathon.projectbackend.models.Action;
import hr.in2.hackathon.projectbackend.models.DTO.ActionDto;
import hr.in2.hackathon.projectbackend.models.Message;
import hr.in2.hackathon.projectbackend.models.User;
import hr.in2.hackathon.projectbackend.models.UserAction;
import hr.in2.hackathon.projectbackend.repositories.ActionRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hr.in2.hackathon.projectbackend.repositories.MessageRepository;
import hr.in2.hackathon.projectbackend.repositories.UserActionRepository;
import hr.in2.hackathon.projectbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actions")
public class ActionsController {

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private UserActionRepository userActionRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Action> getAllActions(){
        return this.actionRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Action getAction(@PathVariable("id") Integer id){
        Action action = this.actionRepository.findOne(id);
        return action;
    }

    @RequestMapping(value = "{id}/details", method = RequestMethod.GET)
    public ActionDto getFullActionDetails(@PathVariable("id") Integer id) {
        Action action = this.actionRepository.findOne(id);

        List<UserAction> userActionsTrue = this.userActionRepository.findAllByActionIdAndResponse(id, true);

        List<User> usersComingToAction = userActionsTrue.stream()
            .map(ua -> this.userRepository.findOne(ua.getUserId()))
            .collect(Collectors.toList());

        List<Message> messages = this.messageRepository.findAllByActionId(action.getId());

        return new ActionDto(action, usersComingToAction, messages);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Action addAction(@RequestBody Action action){
        return this.actionRepository.save(action);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Action editAction(@PathVariable("id") Integer id, @RequestBody Action newAction){
        Action action = this.actionRepository.findOne(id);
        action.setActionLocationX(newAction.getActionLocationX());
        action.setActionLocationY(newAction.getActionLocationY());
        action.setBaseLocationX(newAction.getBaseLocationX());
        action.setBaseLocationY(newAction.getBaseLocationY());
        action.setDescription(newAction.getDescription());
        action.setHeading(newAction.getHeading());
        action.setId(newAction.getId());
        action.setMeetingTime(newAction.getMeetingTime());
        action.setStatus(newAction.getStatus());
        return action;
    }

    @RequestMapping(value = "{id}/messages", method = RequestMethod.GET)
    public List<Message> findAllMessagesForAction(@PathVariable("id") Integer id){
        return this.actionRepository.findAllMessagesForAction(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public void assingActionToUser(@PathVariable("id") Integer id, @RequestBody Map<String, Object> body){
       Integer userId = (Integer) body.get("userId");
       UserAction userAction = new UserAction();
       userAction.setActionId(id);
       userAction.setUserId(userId);
    }




}


