package hr.in2.hackathon.projectbackend.models.DTO;

import hr.in2.hackathon.projectbackend.models.Action;
import hr.in2.hackathon.projectbackend.models.Message;
import hr.in2.hackathon.projectbackend.models.User;
import hr.in2.hackathon.projectbackend.models.UserAction;

import java.util.List;

public class ActionDto {

    private Action action;
    private List<User> users;
    private List<Message> messages;

    public ActionDto() {}

    public ActionDto(Action action, List<User> users, List<Message> messages) {
        this.action = action;
        this.users = users;
        this.messages = messages;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
