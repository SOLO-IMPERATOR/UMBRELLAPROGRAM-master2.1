package com.example.First.Controllers;
   /*
import java.util.*;
import java.util.stream.Collectors;

import com.example.First.ClassEntity.ActClassfifcation;
import com.example.First.repo.ActClassificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



public class ActClassificationController  {
    @Autowired
        private ActClassificationRepo actClassificationRepo;

    @RequestMapping(value = "/greeting",params = "getAct")
    public String GetAct(Model model) {
        if(ControllerFirst.getInformationSystemChangeGlob()!=null) {
            List<ActClassfifcation> act = (List<ActClassfifcation>) actClassificationRepo.findAll();
            List<ActClassfifcation> isact = act.stream().filter(a -> Objects.equals(a.getInfsysid(), ControllerFirst.getInformationSystemChangeGlob().getId())).collect(Collectors.toList());
            model.addAttribute("ActClassif", isact);
            return "greeting";
        }
        return "redirect:/greeting?GetInformationSystem";
    }

    @RequestMapping(value = "/greeting",params = "sendAct", method = RequestMethod.POST)
    public String sendAct(Model model , @ModelAttribute ActClassfifcation actClassfifcation,@RequestParam int send) {
        if(actClassfifcation.getLvlAccess().equalsIgnoreCase("Высокий")||actClassfifcation.getLvlCell().equalsIgnoreCase("Высокий")||actClassfifcation.getLvlConfid().equalsIgnoreCase("Высокий")){
            actClassfifcation.setLvlSecurity("УЗ 3");
            if(actClassfifcation.getMashtab().equalsIgnoreCase("Объектовый")){
                actClassfifcation.setClassSecurity("К 3");
            }else {
                actClassfifcation.setClassSecurity("К 3");
            }
        }else if(actClassfifcation.getLvlAccess().equalsIgnoreCase("Средний")||actClassfifcation.getLvlCell().equalsIgnoreCase("Средний")||actClassfifcation.getLvlConfid().equalsIgnoreCase("Средний")){
            actClassfifcation.setLvlSecurity("УЗ 2");
            if(actClassfifcation.getMashtab().equalsIgnoreCase("Объектовый")){
                actClassfifcation.setClassSecurity("К 1");
            }else {
                actClassfifcation.setClassSecurity("К 2");
            }
        }else {
            actClassfifcation.setLvlSecurity("УЗ 1");
            actClassfifcation.setClassSecurity("К 1");
        }
        if(send==2){
            actClassificationRepo.save(actClassfifcation);
        }
        if(send==3){
            actClassificationRepo.deleteById(actClassfifcation.getId());
        }
        if(send==1){
            ActClassfifcation actClassfifcation1 = new ActClassfifcation(actClassfifcation.getLvlConfid(),actClassfifcation.getLvlCell(),actClassfifcation.getLvlAccess(),actClassfifcation.getMashtab(),actClassfifcation.getLvlSecurity(),actClassfifcation.getClassSecurity(),actClassfifcation.getInfsysid());
            actClassificationRepo.save(actClassfifcation1);
        }
        List<ActClassfifcation> act = (List<ActClassfifcation>) actClassificationRepo.findAll();
        List<ActClassfifcation> isact = act.stream().filter(a -> Objects.equals(a.getInfsysid(),ControllerFirst.getInformationSystemChangeGlob().getId())).collect(Collectors.toList());
        model.addAttribute("ActClassif",isact);
        return "redirect:/greeting?getAct";
    }




}
*/