package com.magmutual.spring.react.mysql.dao;

import java.util.Date;
import java.util.List;

import com.magmutual.spring.react.mysql.modal.User;
public interface UserInformationDAO {

    List<User> getAll();

    User getUser(int id);

    List <User> getUserByProfession(String profession);

    List <User> getNewAnnualUsers(Date date);

//    void save(User user);
//
//    void delete(int id);

}