package com.magmutual.spring.react.mysql.service;

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
    public List<User> get() {
        return userDAO.get();
    }

    @Transactional
    @Override
    public User get(int id) {
        return userDAO.get(id);
    }

    @Transactional
    @Override
    public void save(User employee) {
        userDAO.save(employee);

    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);

    }
}

