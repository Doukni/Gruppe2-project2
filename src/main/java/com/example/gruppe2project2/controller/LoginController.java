package com.example.gruppe2project2.controller;


import com.example.gruppe2project2.model.UserInfo;
import com.example.gruppe2project2.repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepo userRepo;


    @GetMapping("/loginPage")
    public String showLoginPage() {
        return "loginPage";
    }

    @PostMapping("/loginPage")
    public String processLogin(@RequestParam String email,
                               @RequestParam String password,
                               HttpSession session,
                               Model model){
        UserInfo userInfo = userRepo.findByEmail(email);

        if (userInfo != null && userInfo.getPassword().equals(password)) {
            session.setAttribute("user", userInfo);
            return "redirect:/mainPage";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "loginPage";
        }
    }
}
