package com.example.CourseMaven.DesignPattern;

import com.example.CourseMaven.Model.Ebooks;
import com.example.CourseMaven.Model.UserModel;

import java.util.List;
import java.util.Observer;

public interface Subject {

    public void registerSubs(Ebooks o, Integer id);


    public void unregisterSub(UserModel o);

    public void notifyUser();


}
