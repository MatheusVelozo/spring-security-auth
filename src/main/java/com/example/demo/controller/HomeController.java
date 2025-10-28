package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Authentication auth, Model model) {
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        model.addAttribute("isAdmin", isAdmin);

        model.addAttribute("user", auth.getName());
        return "home";
    }
}
