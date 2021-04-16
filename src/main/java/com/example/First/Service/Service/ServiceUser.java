package com.example.First.Service.Service;

import com.example.First.Security.ROLE;
import com.example.First.Security.USER;
import com.example.First.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;

@Service
public class ServiceUser {
    @Lazy
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepo;

    public void addUser(USER user){
        user.setRoles(Collections.singleton(ROLE.USER));
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
    public USER getUser() {
        User userdetail = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        USER user =userRepo.findByUsername(userdetail.getUsername());
        return user;
    }

}
