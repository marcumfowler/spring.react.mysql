package com.magmutual.spring.react.mysql.service;

import java.util.Date;
import java.util.List;

import com.magmutual.spring.react.mysql.dao.UserInformationDAO;
import com.magmutual.spring.react.mysql.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInformationServiceImp implements UserInformationService {

    @Autowired
    private UserInformationDAO userDAO;

    @Transactional
    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Transactional
    @Override
    public User getUserByProfession(String profession) {
        return userDAO.getUserByProfession(profession);
    }

    @Override
    public List<User> getUsersInDate(Date date, Date date2) {
        return null;
    }
}

