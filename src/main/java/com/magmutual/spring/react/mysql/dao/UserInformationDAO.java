package com.magmutual.spring.react.mysql.dao;

import java.util.List;

import com.magmutual.spring.react.mysql.modal.User;
public interface UserInformationDAO {

    List<User> getAll();

    User getUser(int id);

    User getUserByProfession(String profession);

    void save(User user);

    void delete(int id);

}