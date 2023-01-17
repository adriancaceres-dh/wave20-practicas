package com.socialmeli.be_java_hisp_w20_g8.models;

import lombok.EqualsAndHashCode;
import lombok.ToString;

public abstract class Person {

    private Integer id;
    private String user_name;

    public Person(Integer id, String user_name) {
        this.id = id;
        this.user_name = user_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}