package com.example.First.Controllers;

import com.example.First.ClassEntity.OperatorPersData;
import com.example.First.Service.Service.ServiceData;
import com.example.First.repo.OperatorRepo;
import groovy.lang.Grab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Grab("org.webjars:jquery:2.0.3-1")

@Controller
public class DataController {
    @Autowired
    private  OperatorRepo operatorRepo;
    @Autowired
    ServiceData service;

    @RequestMapping(value = "/data")
    public String getAllOperator(Model model) {
        model.addAttribute("listoperator", service.getAll());
        return "objectdata";
    }

    @RequestMapping(value = "/data/{idoperat}", method = RequestMethod.GET)
    public String getOperatorOnId(Model model, @PathVariable int idoperat) {
        model.addAttribute("operator",service.getOperatorOnId(idoperat));
        return "setobjectdata";
    }

    @RequestMapping(value = "/data", params = "getFormOperator")
    public String getFormOperator(Model model) {
        return "setobjectdata";
    }

    @RequestMapping(value = "/data", params = "sendOperator", method = RequestMethod.POST)
    public String sendOperator(Model model, @ModelAttribute OperatorPersData operator) {
        service.addNewOperator(operator);
            return "redirect:/data";
    }

}

