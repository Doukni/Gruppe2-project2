package com.example.gruppe2project2.repository;

import com.example.gruppe2project2.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {


}
