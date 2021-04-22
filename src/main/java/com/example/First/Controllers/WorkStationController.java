package com.example.First.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WorkStationController {

    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/WorkStation", params="getWorkStation", method = RequestMethod.GET)
    public String getAllWs(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId)
    {
        return "workstation";
    }
}
