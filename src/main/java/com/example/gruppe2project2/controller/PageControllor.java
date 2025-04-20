package com.example.gruppe2project2.controller;


import com.example.gruppe2project2.model.UserInfo;
import com.example.gruppe2project2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class PageControllor {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String mainPage() {
        return "Index";
        // it returns the html for you to see on the page which is called "Index"
        // so its like a print statement but it prints what you have in the html
    }

    @GetMapping("/createAccount")
    public String createAccountPage() {
        return "createAccount";

    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";

    }

    @GetMapping(value = "/userInfo")
    public List<UserInfo> getUserInfo(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUserInfo(@RequestBody UserInfo userInfo){
        userRepo.save(userInfo);
        return "Info saved";
    }

}
