package com.magmutual.spring.react.mysql.dao;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.magmutual.spring.react.mysql.modal.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInformationDAOImp implements UserInformationDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        Session currSession = entityManager.unwrap(Session.class);
        Query<User> query = currSession.createQuery("from User", User.class);
        List<User> list = query.getResultList();
        System.out.println(list);
        return list;
    }

    @Override
    public User getUser(int id) {
        Session currSession = entityManager.unwrap(Session.class);
        return currSession.get(User.class, id);
    }

    @Override
    public User getUserByProfession(String profession) {
        Session currSession = entityManager.unwrap(Session.class);
        return currSession.get(User.class, profession);
    }

    @Override
    public void save(User user) {

        Session currSession = entityManager.unwrap(Session.class);
        currSession.saveOrUpdate(user);
    }

    @Override
    public void delete(int id) {
        Session currSession = entityManager.unwrap(Session.class);
        User emp = currSession.get(User.class, id);
        currSession.delete(emp);
    }
}

