package com.example.First.Controllers;

/*
import com.example.First.ClassEntity.ActClassfifcation;
import com.example.First.ClassEntity.InformationSystem;
import com.example.First.ClassEntity.OperatorPersData;
import com.example.First.ClassEntity.PlaceObrabotPD;
import com.example.First.repo.PlaceObrabotPDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class PlaceObrabotPDController {
    @Autowired
    private PlaceObrabotPDRepo placeObrabotPDRepo;
    @RequestMapping(value = "/greeting",params = "GetPlace")
    public String OneFormOperatorCreate(Model model) {
        List<PlaceObrabotPD> place = (List<PlaceObrabotPD>) placeObrabotPDRepo.findAll();
        List<PlaceObrabotPD> isplace =place.stream().filter(a -> Objects.equals(a.getInfsysid(), ControllerFirst.getInformationSystemChangeGlob().getId())).collect(Collectors.toList());
        model.addAttribute("PlacePd",isplace);
        return "greeting";
    }


    @RequestMapping(value = "/greeting",params = "sendPlace",method = RequestMethod.POST)
    public String sendOperator(Model model, @RequestParam int send, @ModelAttribute PlaceObrabotPD placeObrabotPD)  {
        if(send==1){
            PlaceObrabotPD placeObrabotPD1 = new PlaceObrabotPD(placeObrabotPD.getId(),placeObrabotPD.getPlace(),placeObrabotPD.getFloor(),placeObrabotPD.getAdres(),placeObrabotPD.getInfsysid());
            placeObrabotPDRepo.save(placeObrabotPD1);
        }
        if(send==2){
            placeObrabotPDRepo.save(placeObrabotPD);
        }
        if(send==3){
            placeObrabotPDRepo.deleteById(placeObrabotPD.getId());
        }
        return "redirect:/greeting?GetPlace";
    }


}
*/