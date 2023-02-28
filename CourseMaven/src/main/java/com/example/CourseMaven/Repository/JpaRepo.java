package com.example.CourseMaven.Repository;

import com.example.CourseMaven.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JpaRepo extends JpaRepository<UserModel, Integer> {

    List<UserModel> findByAddress(String address);

}
