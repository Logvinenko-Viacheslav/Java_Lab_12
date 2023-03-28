package com.example.lab12.controller;

import com.example.lab12.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController{
    @PostMapping("/hello")
    public String hi(@RequestParam("username") String name, @RequestParam("userage") int age, Model model){
        User user = new User(name, age);
        model.addAttribute("user", user);
        return "hello";
    }
}