package com.example.CourseMaven.Model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ebook")
public class Ebooks {


    @Id
    @GeneratedValue
    private int id;

    private String bookname;

    private String author;

    private int price;

    private String availability;



    @Nullable
    @ManyToOne(fetch=FetchType.LAZY)
    private UserModel user;

    public Ebooks(){}

    public Ebooks(String bookname, String author, int price, String availability, UserModel user) {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        this.availability = availability;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }


}
