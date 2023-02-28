package com.example.CourseMaven.Services;


import com.example.CourseMaven.DesignPattern.SubjectImplementation;
import com.example.CourseMaven.Model.Ebooks;
import com.example.CourseMaven.Model.UserModel;
import com.example.CourseMaven.Repository.JpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private JpaRepo repo;

    @Autowired
    private SubjectImplementation subjectImplementation;

    public UserModel sendUserbasedonId(Integer id){
        return  repo.findById(id).get();
    }

    public String RegisterUser(Ebooks ebooks, Integer id){
        subjectImplementation.registerSubs(ebooks,id);
        return "Added";
    }

    public String DeleteList(){
        return subjectImplementation.clearList();
    }



}
