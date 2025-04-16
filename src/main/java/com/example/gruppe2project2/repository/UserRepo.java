package com.example.gruppe2project2.repository;

import com.example.gruppe2project2.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {


    //List<UserInfo> findByEmail(String email);
    UserInfo findByEmail(String email);
}
