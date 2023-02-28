package com.example.CourseMaven.Repository;

import com.example.CourseMaven.Model.Ebooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepo extends JpaRepository<Ebooks,Integer> {

    Ebooks findBybookname(String bookname);






}
