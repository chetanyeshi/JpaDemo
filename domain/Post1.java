package com.codekul.jpaDemo6818.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post1 {

@Id
   private Integer id;
    private String name;
    private String city;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }


private String balance;

}
