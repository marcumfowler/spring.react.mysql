package com.magmutual.spring.react.mysql.controller;

import java.util.List;

import com.magmutual.spring.react.mysql.modal.User;
import com.magmutual.spring.react.mysql.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserInformationController {

    @Autowired
    private UserInformationService userInformationService;



    //Endpoint to return a list of users created between a date range


    //Custom Endpoint that you design on your own.
    @GetMapping("/users")
    public List<User> getAll() {
        return userInformationService.getAll();
    }

    //    Endpoint to return a specific user (and all associated information)
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return userInformationService.getUser(id);
    }

    //    Endpoint to return a list of users based on a specific profession
    @GetMapping("users/{profession}")
    public User getUsersByProfession(@PathVariable String profession) {
        return userInformationService.getUserByProfession(profession);
    }
}