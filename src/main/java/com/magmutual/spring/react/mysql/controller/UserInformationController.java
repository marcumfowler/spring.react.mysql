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

    @GetMapping("/users")
    public List<User> get() {
        return userInformationService.get();
    }

    @PostMapping("/users")
    public User save(@RequestBody User user) {
        userInformationService.save(user);
        return user;
    }

    @GetMapping("/users/{id}")
    public User get(@PathVariable int id) {
        return userInformationService.get(id);
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable int id) {

        userInformationService.delete(id);

        return "User removed with id " + id;

    }

    @PutMapping("/users")
    public User update(@RequestBody User user) {
        userInformationService.save(user);
        return user;
    }
}