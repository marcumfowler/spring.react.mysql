package com.magmutual.spring.react.mysql.service;

import com.magmutual.spring.react.mysql.modal.User;

import java.util.Date;
import java.util.List;

public interface UserInformationService {
    List<User> getAll();

    User getUser(int id);

    User getUserByProfession(String profession);

    List<User> getNewAnnualUsers(Date date);

}
