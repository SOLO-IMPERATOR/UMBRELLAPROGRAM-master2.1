package com.example.First.Controllers;

import com.example.First.ClassEntity.InformationSystem;
import com.example.First.ClassEntity.OperatorPersData;
import com.example.First.Service.Service.ServiceInfSystem;
import groovy.lang.Grab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Grab("org.webjars:jquery:2.0.3-1")

@Controller
public class InformationSystemController {
  @Autowired
  ServiceInfSystem service;
  @Autowired
  private HttpSession httpSession;
    @RequestMapping(value = "data/{id}/IS",method = RequestMethod.GET)
    public String getInfsys(Model model,@PathVariable int id) {
        model.addAttribute("listinfsys",service.getInfSysFromOperator(id));
        return "infsysdata";
    }

    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}",method = RequestMethod.GET)
    public String getInfSystemFromId(Model model, @PathVariable int idoperatorForis,@PathVariable int infsysId)  {
        model.addAttribute("infsystem",service.getOperatorOnId(infsysId,idoperatorForis));
        return "setinfsystem";
    }
    @RequestMapping(value = "/data/IS",params = "GetFormInfsys",method = RequestMethod.GET)
    public String getFormInfSys(Model model)  {
        model.addAttribute("operatorid",httpSession.getAttribute("id_operator"));
        return "setinfsystem";
    }

   @RequestMapping(value = "/data/IS",params = "sendInfSystem",method = RequestMethod.POST)
    public String addinfsys(Model model, @ModelAttribute InformationSystem informationSystem)  {
      service.addNewInfSystem(informationSystem);
       return "redirect:/data/IS?idoperatorForis="+httpSession.getAttribute("id_operator");
  }



}
