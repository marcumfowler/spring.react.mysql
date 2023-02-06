package com.magmutual.spring.react.mysql.modal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "user_information")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String first;
    @Column
    private String last;
    @Column
    private String email;
    @Column
    private String profession;
    @Column
    private String country;
    @Column
    private String city;
    @Column
    private Date date;

    public User(String first, String last, String email, String profession, String city, String country, Date date) {

        this.first = first;
        this.last = last;
        this.email = email;
        this.profession = profession;
        this.city = city;
        this.country = country;
        this.date = date;
    }

    protected User() {}

    @Override
    public String toString() {
        return "User [id= " + id + ", name=" + first + " " + last + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstNameName() {
        return first;
    }

    public void setFirstName(String first) {
        this.first = first;
    }

    public String getLastNameName() {
        return last;
    }

    public void setLastName(String name) {
        this.last = last;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}