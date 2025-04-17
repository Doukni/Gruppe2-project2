package com.example.gruppe2project2.controller;


import com.example.gruppe2project2.repository.UserRepo;
import com.example.gruppe2project2.repository.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishlistController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WishlistRepo wishlistRepo;

    @GetMapping("/wishlist")
    public String wishlist(Model model) {
        return "wishlist";
    }





}
