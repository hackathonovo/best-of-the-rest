package hr.in2.hackathon.projectbackend.controllers;

import hr.in2.hackathon.projectbackend.models.Action;
import hr.in2.hackathon.projectbackend.models.DTO.UserDTO;
import hr.in2.hackathon.projectbackend.models.DTO.UserSpecialityDTO;
import hr.in2.hackathon.projectbackend.models.Speciality;
import hr.in2.hackathon.projectbackend.models.User;
import hr.in2.hackathon.projectbackend.models.UserAction;
import hr.in2.hackathon.projectbackend.models.UserSpeciality;
import hr.in2.hackathon.projectbackend.repositories.ActionRepository;
import hr.in2.hackathon.projectbackend.repositories.SpecialityRepository;
import hr.in2.hackathon.projectbackend.repositories.UserActionRepository;
import hr.in2.hackathon.projectbackend.repositories.UserRepository;
import hr.in2.hackathon.projectbackend.repositories.UserSpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSpecialityRepository userSpecialityRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private UserActionRepository userActionRepository;
    @Autowired
    private ActionRepository actionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        //Posalji mail
//    MailSenderClass mailSender = new MailSenderClass();
//    mailSender.sendMail("in2@eestec-zg.hr", "edi.sinovcic@gmail.com", "Deri prijo", "Salji seeee");
        return this.userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody UserDTO userDTO) {
        User user = userDTO.getUser();
        this.userRepository.save(user);
        for (UserSpecialityDTO speciality : userDTO.getSpecialities()) {
            UserSpeciality userSpeciality = new UserSpeciality(userDTO.getUser().getId(), speciality.id, speciality.level);
            this.userSpecialityRepository.save(userSpeciality);
        }
        return user;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Integer id) {
        return this.userRepository.findOne(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public User editUser(@PathVariable("id") Integer id, @RequestBody UserDTO newUserDto) {
        User user = this.userRepository.findOne(id);

        User newUser = newUserDto.getUser();

        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setWorkLocationX(newUser.getWorkLocationX());
        user.setWorkLocationY(newUser.getWorkLocationY());
        user.setHomeLocationX(newUser.getHomeLocationX());
        user.setHomeLocationY(newUser.getHomeLocationY());
        user.setAvailableFrom(newUser.getAvailableFrom());
        user.setAvailableTo(newUser.getAvailableTo());
        user.setContact(newUser.getContact());
        user.setEmail(newUser.getEmail());
        this.userRepository.save(user);

        this.userSpecialityRepository.deleteAllSpecialitiesByUser(user.getId());

        for (UserSpecialityDTO usDto : newUserDto.getSpecialities()) {
            UserSpeciality us = new UserSpeciality(user.getId(), usDto.id, usDto.level);
            this.userSpecialityRepository.save(us);
        }

        return user;
    }

    @RequestMapping(value = "{id}/specialities", method = RequestMethod.GET)
    public List<Speciality> getAllUserSpecialities(@PathVariable("id") Integer id) {
        List<Speciality> spList = new LinkedList<>();
        List<UserSpeciality> userSpecialities = this.userSpecialityRepository.findAllSpecialitiesOfUser(id);
        for (UserSpeciality us : userSpecialities) {
            Speciality s = this.specialityRepository.findOne(us.getSpecialityId());
            spList.add(s);
        }
        return spList;
    }

    //users/{id}/actions
    @RequestMapping(value = "{id}/actions", method = RequestMethod.GET)
    public List<Action> getAllActionsForUser(@PathVariable("id") Integer id) {
        List<Action> actions = new LinkedList<>();
        List<UserAction> userActions = this.userActionRepository.findAllActionsForUser(id);
        for (UserAction ua : userActions) {
            Action action = this.actionRepository.findOne(id);
            actions.add(action);
        }
        return actions;

    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public List<User> getFilteredUsers(String category, String speciality, Integer level) {
        List<UserSpeciality> userSpecialities = new LinkedList<>();

        List<User> users = category != null && !"".equals(category)
                ? this.userRepository.findAllByCategory(category)
                : this.userRepository.findAll();

        List<User> filteredUsers = new LinkedList<>(users);

        if (level != null) {
            filteredUsers = users.stream()
                    .filter(u -> (long) this.userSpecialityRepository.findAllByLevelGreaterThan(level).size() > 0)
                    .collect(Collectors.toList());
        }

        if (speciality != null && !"".equals(speciality)) {
            filteredUsers = filteredUsers.stream()
                    .filter(u -> this.userSpecialityRepository.findAllSpecialitiesOfUser(u.getId()).stream()
                        .filter(us -> {
                            Speciality s = this.specialityRepository.findOneBySpecialityId(us.getSpecialityId());
                            return s.getName().equals(speciality);
                        })
                    .count() > 0)
            .collect(Collectors.toList());
        }


        return filteredUsers;
    }
}
