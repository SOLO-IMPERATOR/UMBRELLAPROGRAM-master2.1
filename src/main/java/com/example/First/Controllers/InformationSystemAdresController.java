package com.example.First.Controllers;


import com.example.First.ClassEntity.InformationSystem;
import com.example.First.ClassEntity.InformationSystemAdress;
import com.example.First.Service.Service.ServiceInfSysAdres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InformationSystemAdresController {
    @Autowired
    private ServiceInfSysAdres serviceInfSysAdres;

    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/AdresIs",params = "changeAdresIs",method = RequestMethod.POST)
    public String changeInfsysAdres(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute InformationSystemAdress informationSystemAdress) {
        serviceInfSysAdres.changeInfSysAdresForIS(infsysId,informationSystemAdress,idoperatorForis);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/AdresIs?getAdresIs";
    }

    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/AdresIs",params = "getAdresIs",method = RequestMethod.GET)
    public String getInfsysAdres(Model model,@PathVariable int idoperatorForis,@PathVariable int infsysId) {
        model.addAttribute("listinfsysadres", serviceInfSysAdres.getinfSysAdresFromIS(infsysId,idoperatorForis));
        return "infsysadres";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/AdresIs",params = "addAdresIs",method = RequestMethod.POST)
    public String addInfsysAdres(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute InformationSystemAdress informationSystemAdress) {
        serviceInfSysAdres.addInfSysAdresForIS(infsysId,informationSystemAdress,idoperatorForis);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/AdresIs?getAdresIs";
    }

    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/AdresIs",params = "deleteAdresIs",method = RequestMethod.POST)
    public String deleteInfsysAdres(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute InformationSystemAdress informationSystemAdress) {
        serviceInfSysAdres.deleteInfSysAdresForIS(infsysId,informationSystemAdress,idoperatorForis);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/AdresIs?getAdresIs";
    }


}
