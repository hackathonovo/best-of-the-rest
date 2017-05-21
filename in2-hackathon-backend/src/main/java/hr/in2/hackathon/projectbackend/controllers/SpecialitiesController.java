package hr.in2.hackathon.projectbackend.controllers;

import hr.in2.hackathon.projectbackend.models.Speciality;
import hr.in2.hackathon.projectbackend.models.User;
import hr.in2.hackathon.projectbackend.repositories.SpecialityRepository;
import hr.in2.hackathon.projectbackend.repositories.UserRepository;
import hr.in2.hackathon.projectbackend.repositories.UserSpecialityRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specialities")
public class SpecialitiesController {

    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private UserSpecialityRepository userSpecialityRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Speciality> getAllSpecialities(){
        return this.specialityRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Speciality getSpeciality(@PathVariable("id") Integer id){
        Speciality speciality = this.specialityRepository.findOne(id);
        return speciality;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Speciality addSpeciality(@RequestBody Speciality speciality){
        return this.specialityRepository.save(speciality);
    }

    @RequestMapping(value = "{id}/users", method = RequestMethod.GET)
    public List<User> getAllUsersWithSpeciality(@PathVariable("id") Integer id){
        return this.userSpecialityRepository.findAllUsersOfSpeciality(id).stream()
            .map(ue -> this.userRepository.findOne(ue.getId()))
            .collect(Collectors.toList());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSpeciality(@PathVariable("id") Integer id) {
        this.specialityRepository.delete(id);
    }

}
