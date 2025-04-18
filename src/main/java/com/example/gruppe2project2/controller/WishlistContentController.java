package com.example.gruppe2project2.controller;


import com.example.gruppe2project2.model.Item;
import com.example.gruppe2project2.model.UserInfo;
import com.example.gruppe2project2.model.Wishlist;
import com.example.gruppe2project2.repository.ItemRepo;
import com.example.gruppe2project2.repository.UserRepo;
import com.example.gruppe2project2.repository.WishlistRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishlistContentController {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WishlistRepo wishlistRepo;

    @Autowired
    private ItemRepo itemRepo;


    @GetMapping("/wishlist/{id}")
    public String showWishlistContent(@PathVariable Integer id, Model model, HttpSession session) {
        UserInfo user = (UserInfo) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Wishlist wishlist = wishlistRepo.findById(id).orElse(null);
        model.addAttribute("wishlist", wishlist);
        model.addAttribute("items", wishlist.getItems());
        model.addAttribute("wishlists", wishlistRepo.findByUser(user));

        return "wishlistContent";
    }

    @PostMapping("/wishlist/{id}")
    public String addItemToWishlist(@PathVariable Integer id, @RequestParam String itemName, Model model, HttpSession session) {
        UserInfo user = (UserInfo) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Wishlist wishlist = wishlistRepo.findById(id).orElse(null);

        if (wishlist == null) {
            return "redirect:/saveWishlist";
        }

        Item newItem = new Item(itemName, wishlist);
        itemRepo.save(newItem);

        wishlist.getItems().add(newItem);
        wishlistRepo.save(wishlist);

        model.addAttribute("wishlist", wishlist);
        model.addAttribute("items", wishlist.getItems());
        model.addAttribute("wishlists", wishlistRepo.findByUser(user));

        return "wishlistContent";
    }
}


