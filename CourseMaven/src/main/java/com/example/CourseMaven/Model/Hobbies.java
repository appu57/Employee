package com.example.CourseMaven.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

@Entity
@Data
public class Hobbies {

    @Id
    @GeneratedValue
    private int id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserModel user;

   public Hobbies(){}
    public Hobbies(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
