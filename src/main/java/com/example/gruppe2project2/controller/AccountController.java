package com.example.gruppe2project2.controller;


import com.example.gruppe2project2.model.UserInfo;
import com.example.gruppe2project2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/saveAccount")
    public String createAccount(Model model) {
        model.addAttribute("user", new UserInfo());
        return "createAccount";
    }

    @PostMapping("/saveAccount")
    public String createAccount(@ModelAttribute("user") UserInfo userinfo) {
        userRepo.save(userinfo);
        return "redirect:/";
    }
}
