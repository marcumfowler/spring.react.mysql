package com.magmutual.spring.react.mysql.service;

import com.magmutual.spring.react.mysql.modal.User;

import java.util.List;

public interface UserInformationService {
    List<User> getAll();

    User getUser(int id);

    void save(User employee);

    void delete(int id);
}
