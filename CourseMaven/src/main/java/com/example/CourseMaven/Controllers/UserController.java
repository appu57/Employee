package com.example.CourseMaven.Controllers;


import com.example.CourseMaven.DesignPattern.SubjectImplementation;
import com.example.CourseMaven.Model.Ebooks;
import com.example.CourseMaven.Model.UserModel;
import com.example.CourseMaven.Repository.BookRepo;
import com.example.CourseMaven.Repository.JpaRepo;
import com.example.CourseMaven.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.stream.Collectors;


@RestController
public class UserController {

    @Autowired
    private JpaRepo repo;

    @Autowired
    private BookRepo bookrepo;

    private UserService userService;

    int counter=0;


    public  UserController(UserService userService){

        this.userService=userService;

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/postUser")
    public ResponseEntity<UserModel> postUsers(@RequestBody UserModel newuser)
    {
       Integer id=repo.save(newuser).getId();
//       return repo.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK)
                .body(repo.findById(id).get());
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getuser")
    public List<UserModel> sendUser(){
        List<UserModel> list = repo.findAll();
        return list;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getuseraddress/{address}")
    public List<UserModel> sendUserbasedonaddress(@PathVariable String address){

        List<UserModel> list = repo.findByAddress(address).stream().filter(data->data.getFirstname().length()>2)
//                .sorted((a,b)->a.getFirstname().length()-b.getFirstname().length())
                .sorted((a,b)->(a.getFirstname()).compareTo(b.getFirstname()))
                .collect(Collectors.toList());

        return list;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getParticularUser/{id}")
    public UserModel sendUserbasedonId(@PathVariable Integer id){
        UserModel userModel=userService.sendUserbasedonId(id);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(userModel);

        return userModel;

    }

    @CrossOrigin(origins = "http:/localhost:4200")
    @GetMapping("/addSubscriber/{id}/{bookname}")
    public ResponseEntity<String> addUser(@PathVariable Integer id, @PathVariable String bookname){
        Ebooks books=bookrepo.findBybookname(bookname);
        System.out.println(books.getAuthor());

         String data= userService.RegisterUser(books,id);

        System.out.println(data);
        return ResponseEntity.status(HttpStatus.OK).body("Book Subscribed");
    }

    @CrossOrigin(origins = "http:/localhost:4200")
    @GetMapping("/deleteSubscriber/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){

//        observers.unregisterSub(repo.findById(id).get());
        return ResponseEntity.status(HttpStatus.OK).body(String.format("User Deleted"));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/postBook")
    public String postBooks(@RequestBody Ebooks ebook)
    {



        System.out.println(ebook);
         bookrepo.save(ebook);
//       return repo.findById(id).get();
        return "Added";
    }







}
