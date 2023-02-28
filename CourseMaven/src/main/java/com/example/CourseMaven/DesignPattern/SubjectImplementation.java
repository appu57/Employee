package com.example.CourseMaven.DesignPattern;

import com.example.CourseMaven.Model.Ebooks;
import com.example.CourseMaven.Model.UserModel;
import com.example.CourseMaven.Repository.BookRepo;
import com.example.CourseMaven.Repository.JpaRepo;
import com.example.CourseMaven.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

@Service
public class SubjectImplementation implements Subject{

    ArrayList<Ebooks> observers;

    public iObserver iobserver;



    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private JpaRepo userrepo;


//    @Autowired
//    private ebookservice eservice;

    public SubjectImplementation()
    {
        observers=new ArrayList<Ebooks>();
    }

    @Override
    public void registerSubs(Ebooks o,Integer id) {
        observers.add(o);

        for(Ebooks book:observers){
            UserModel user=userrepo.findById(id).get();
            book.setUser(user);
        }
    }




    @Override
    public void unregisterSub(UserModel o) {

        int observerIndex=observers.indexOf(o);
        observers.remove(o);
        System.out.println(observers);

    }

    @Override
    public void notifyUser() {
        for(Ebooks books:observers){
              iobserver.update(books);
        }
    }

    public String clearList(){
        observers.clear();
        return "Cleare";
    }


}
