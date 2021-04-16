package com.example.First.Controllers;

/*
import com.example.First.ClassEntity.ListPD;
import com.example.First.ClassEntity.PdForinfSystem;
import com.example.First.repo.ListPDRepo;

import com.example.First.repo.PdForinfSystemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class ListPDController {
    @Autowired
    private ListPDRepo listPDRepo;

    @Autowired
    private PdForinfSystemRepo pdForinfSystemRepo;

    @RequestMapping(value = "/greeting", params = "GetListPD")
    public String OneFormOtvetFaceCreate(Model model) {
        List<ListPD> listPDS = (List<ListPD>) listPDRepo.findAll();
        List<PdForinfSystem> pdis = (List<PdForinfSystem>) pdForinfSystemRepo.findAll();
        List<ListPD> newL = new ArrayList<>();



    for(ListPD k : listPDS){
            boolean t =false;
            for(PdForinfSystem pd : pdis){
                if(k.getId()==pd.getPD().getId()&&pd.getInfsysid()==ControllerFirst.getInformationSystemChangeGlob().getId()){
                    t =true;
                    break;
                }
            }
            if(!t) {
                newL.add(k);
            }

        }
        model.addAttribute("ListPd", newL);
        pdis = pdis.stream().filter(a -> Objects.equals(a.getInfsysid(), ControllerFirst.getInformationSystemChangeGlob().getId())).collect(Collectors.toList());
        model.addAttribute("ListPDInf",pdis);
        return "greeting";
    }

    @RequestMapping(value = "/greeting", params = "sendPD", method = RequestMethod.POST)
    public String sendOtvetFace(Model model, @ModelAttribute ListPD pd, @RequestParam int send, @RequestParam long id) {
        if (send == 4) {
            ListPD listPD = new ListPD(pd.getText());
            listPDRepo.save(listPD);
        }
        if (send == 3) {
            listPDRepo.deleteById(pd.getId());
        }
        if (send == 2) {
            listPDRepo.save(pd);
        }
        if (send == 1) {
            pdForinfSystemRepo.save(new PdForinfSystem(pd,ControllerFirst.getInformationSystemChangeGlob().getId()));
        }
        if (send == 5) {
            pdForinfSystemRepo.deleteById(id);
        }
        return "redirect:/greeting?GetListPD";
    }
}*/
