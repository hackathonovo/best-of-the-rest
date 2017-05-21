package hr.in2.hackathon.projectbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusesController {


    @RequestMapping(value = "/status")
    @ResponseStatus(HttpStatus.OK)
    public void getStatus() {

    }

}
