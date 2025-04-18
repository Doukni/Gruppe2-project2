package com.example.gruppe2project2.controller;


import com.example.gruppe2project2.model.UserInfo;
import com.example.gruppe2project2.model.Wishlist;
import com.example.gruppe2project2.repository.UserRepo;
import com.example.gruppe2project2.repository.WishlistRepo;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class WishlistController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WishlistRepo wishlistRepo;



    // createAccount hed det her før ved ik hvorfor

    @GetMapping("/saveWishlist")
    public String wishListPage(Model model, HttpSession session) {

        UserInfo user = (UserInfo) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("wishlist", new Wishlist());
        model.addAttribute("wishlists", wishlistRepo.findByUser(user));
        return "wishlist";

    }

    @PostMapping("/saveWishlist")
    public String wishListPage(@ModelAttribute("wishlist") Wishlist wishlist,
                                @SessionAttribute("user") UserInfo user) {
        wishlist.setUser(user);
        wishlistRepo.save(wishlist);
        return "redirect:/saveWishlist";
    }
}

//    @GetMapping("/wishlist")
//    public String wishlist(Model model) {
//        return "wishlist";
//    }


//
//    @PostMapping("/wishlist/add")
//    public String addWishlist(@RequestParam("name") String wishlistName,
//                              @SessionAttribute("user") UserInfo user) {
//
//        Wishlist wishlist = new Wishlist();
//        wishlist.setWishlistName(wishlistName);
//        wishlist.setUser(user);
//
//        wishlistRepo.save(wishlist);
//
//        return "redirect:/wishlist";
//    }
//}
