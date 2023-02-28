package com.example.CourseMaven.Model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.List;
import java.util.Observer;

@Entity
@Table(name="user_details")
public class UserModel  {

    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;
    private String address;

    private int age;

    private String gender;

    private String imagePath;

    @OneToMany(mappedBy = "user")
    private List<Hobbies> hobby;

    @OneToMany(mappedBy = "user")
    private List<Ebooks> books;

    public UserModel() {
    }

    public UserModel( String firstname, String lastname, String address, int age, String gender,String imagePath) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.imagePath = imagePath;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Hobbies> getHobby() {
        return hobby;
    }

    public void setHobby(List<Hobbies> hobby) {
        this.hobby = hobby;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Ebooks> getBooks() {
        return books;
    }

    public void setBooks(List<Ebooks> books) {
        this.books = books;
    }
}
