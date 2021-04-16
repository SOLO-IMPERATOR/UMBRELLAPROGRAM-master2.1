package com.example.First.Controllers;

import groovy.lang.Grab;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Grab("org.webjars:jquery:2.0.3-1")

@Controller
public class PersonalLkController {

    @RequestMapping(value = "/personal")
    public String getPersonal(Model model) {
        return "lk";
    }
    @RequestMapping()
    public String goLogin(Model model) {
        return "login";
    }
}
