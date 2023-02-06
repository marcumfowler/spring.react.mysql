package com.magmutual.spring.react.mysql.dao;

import java.util.List;

import com.magmutual.spring.react.mysql.modal.User;
public interface UserInformationDAO {

    List<User> get();

    User get(int id);

    void save(User employee);

    void delete(int id);
}