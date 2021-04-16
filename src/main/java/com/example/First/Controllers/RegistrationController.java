package com.example.First.Controllers;

import com.example.First.Security.ROLE;
import com.example.First.Security.USER;
import com.example.First.Service.Service.ServiceUser;
import com.example.First.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.First.Security.config.WebSecurityConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    ServiceUser serviceUser;

    @GetMapping("/registration")
    public String registration(){
        return  "registration";
    }
    @PostMapping("/registration")
    public String add(USER user, Model model){
        serviceUser.addUser(user);
        return  "redirect:/login";
    }
}
