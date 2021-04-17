package com.example.First.Controllers;

import groovy.lang.Grab;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Grab("org.webjars:jquery:2.0.3-1")

@Controller
public class AllDataConrtoller {
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}", params="getAllData", method = RequestMethod.GET)
    public String getAllOperator(Model model)
    {
        return "AllDataIs";
    }
}
