package com.example.First.Controllers;
/*
import com.example.First.ClassEntity.OtvetFace;
import com.example.First.Service.Service.ServiceOtvFace;
import groovy.lang.Grab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Grab("org.webjars:jquery:2.0.3-1")

@Controller
public class OtvFaceController {

    @Autowired
    ServiceOtvFace serviceOtvFace;

    @RequestMapping(value = "/greeting",params = "GetOtvFace")
    public String OneFormOtvetFaceCreate(Model model) {
        model.addAttribute("otvFace", serviceOtvFace.getAll());
        return "greeting";
    }
    @RequestMapping(value = "/greeting",params = "sendOtvFace",method = RequestMethod.POST)
    public String sendOtvetFace(Model model, @ModelAttribute OtvetFace otvFace, @RequestParam int send) {
        if(send==3){
            serviceOtvFace.deleteFace(otvFace);
        }
        if(send==2){
            serviceOtvFace.replaceFace(otvFace);
        }
        if(send==1){
            serviceOtvFace.addNewFace(otvFace);
        }
        return "redirect:/greeting?GetOtvFace";
    }
}*/