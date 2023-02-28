package com.example.CourseMaven.DesignPattern;

import com.example.CourseMaven.Model.Ebooks;
import com.example.CourseMaven.Model.UserModel;

public class ObserverImplementation implements iObserver {

    private Ebooks ebooks;

    private int Observerid;

    private Subject details;

    public ObserverImplementation(Subject details){
        this.details=details;
    }

    @Override
    public void update(Ebooks ebooks) {
       this.ebooks=ebooks;

    }
}
