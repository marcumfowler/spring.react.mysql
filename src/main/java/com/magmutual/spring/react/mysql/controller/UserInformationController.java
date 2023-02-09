package com.magmutual.spring.react.mysql.controller;

import com.magmutual.spring.react.mysql.modal.User;
import com.magmutual.spring.react.mysql.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserInformationController {

    @Autowired
    private UserInformationService userInformationService;


    //Endpoint to return a list of users created between a date range.
    @GetMapping("/users/{year}")
    public List<User> getNewAnnualUsers(Date date){
        return userInformationService.getNewAnnualUsers(date);
    }

    //Endpoint to return all users and associated data.
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

//    @PostMapping("/users/{id}")
//    public User save(@RequestBody User user) {
//        userInformationService.save(user);
//        return user;
//    }
//
//    @DeleteMapping("/users/{id}")
//    public String delete(@PathVariable int id) {
//
//        userInformationService.delete(id);
//
//        return "User removed with id " + id;
//
//    }
//
//    @PutMapping("/users")
//    public User update(@RequestBody User user) {
//        userInformationService.save(user);
//        return user;
//    }
}