package com.magmutual.spring.react.mysql.dao;

import com.magmutual.spring.react.mysql.modal.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class UserInformationDAOImp implements UserInformationDAO {
    @Autowired
    private EntityManager entityManager;
    Session currSession = entityManager.unwrap(Session.class);


    @Override
    public List<User> getAll() {
        Query<User> query = currSession.createQuery("from User", User.class);
        List <User> list;
        try{
            list = query.getResultList();
        }catch(Exception e){
            throw new RuntimeException("Exception while retrieving user data"+e);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public User getUser(int id) {
        Query<User> query = currSession.createQuery(
                "FROM User U WHERE U.id = :id",
                User.class);
        query.setParameter(id, id);
        User user;
        try{
            user = query.getSingleResult();
        }catch(Exception e){
            throw new RuntimeException("Exception while retrieving user data"+e);
        }
        System.out.println(user);
        return user;    }

    @Override
    public List <User> getUserByProfession(String profession) {
        Query<User> query = currSession.createQuery(
                "FROM User U WHERE U.profession = :profession",
                User.class);
        query.setParameter(profession, profession);
        List <User> list;
        try{
            list = query.getResultList();
        }catch(Exception e){
            throw new RuntimeException("Exception while retrieving user data"+e);
        }
        return list;
    }

    @Override
    public List<User> getNewAnnualUsers(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
//        int year = calendar.get(Calendar.YEAR);
        Query<User> query = currSession.createQuery("from User", User.class);
        List<User> list;
        try{
            list = query.getResultList();
        }catch(Exception e){
            throw new RuntimeException("Exception while retrieving  date data");
        }
// Do some stuff here to filter list
        System.out.println(list);
        return list;
    }
//    @Override
//    public void save(User user) {
//
//        Session currSession = entityManager.unwrap(Session.class);
//        currSession.saveOrUpdate(user);
//    }

//    @Override
//    public void delete(int id) {
//        Session currSession = entityManager.unwrap(Session.class);
//        User emp = currSession.get(User.class, id);
//        currSession.delete(emp);
//    }
}

