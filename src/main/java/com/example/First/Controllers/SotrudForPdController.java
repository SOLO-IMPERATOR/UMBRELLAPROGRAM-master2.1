package com.example.First.Controllers;

/*
import com.example.First.ClassEntity.OperatorPersData;
import com.example.First.ClassEntity.SotrudForPd;
import com.example.First.repo.SotrudForPdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class SotrudForPdController {

    @Autowired
    private SotrudForPdRepo sotrudForPdRepo;

    @RequestMapping(value = "/greeting", params = "GetSotrudForPd")
    public String OneFormOperatorCreate(Model model) {
        List<SotrudForPd> lstsot = (List<SotrudForPd>) sotrudForPdRepo.findAll();
        lstsot = lstsot.stream().filter(a -> Objects.equals(a.getInfsysid().getId(), ControllerFirst.getInformationSystemChangeGlob().getId())).collect(Collectors.toList());
        model.addAttribute("sotrudforpd", lstsot);
        return "greeting";
    }

    @RequestMapping(value = "/greeting", params = "sendSotrudForPd", method = RequestMethod.POST)
    public String send(Model model, @RequestParam int send, @ModelAttribute SotrudForPd sotrudforpd) {
        if (send == 1) {
            sotrudForPdRepo.save(new SotrudForPd(sotrudforpd.getName(),sotrudforpd.getFamily(),sotrudforpd.getOtch(),sotrudforpd.getDolzh(),sotrudforpd.getInfsysid()));
        }
        if (send == 2) {
            sotrudForPdRepo.save(sotrudforpd);
        }
        if (send == 3) {
            sotrudForPdRepo.deleteById(sotrudforpd.getId());
        }
        return "redirect:/greeting?GetSotrudForPd";
    }







}
*/