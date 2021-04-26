package com.example.First.Controllers;

import com.example.First.ClassEntity.ServerRack;
import com.example.First.Service.Service.ServicePlaceProcessingData;
import com.example.First.Service.Service.ServiceServerRack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServerRackController {

    @Autowired
    private ServiceServerRack serviceServerRack;
    @Autowired
    private ServicePlaceProcessingData servicePlaceProcessingData;
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/ServerRack", params="getRack", method = RequestMethod.GET)
    public String getRack(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId)
    {
        model.addAttribute("places",servicePlaceProcessingData.getPlaceFromAdresIs(infsysId,idoperatorForis));
        model.addAttribute("serverrack",serviceServerRack.getServerRack(infsysId,idoperatorForis));
        return "serverrack";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/ServerRack", params="addRack", method = RequestMethod.POST)
    public String addRack(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute ServerRack serverrack)
    {
        serviceServerRack.addServerRack(serverrack);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/ServerRack?getRack";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/ServerRack", params="changeRack", method = RequestMethod.POST)
    public String changeRack(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute ServerRack serverrack)
    {
        serviceServerRack.changeServerRack(serverrack);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/ServerRack?getRack";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/ServerRack", params="delRack", method = RequestMethod.POST)
    public String deleteRack(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute ServerRack serverrack)
    {
        serviceServerRack.deleteServerRack(serverrack);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/ServerRack?getRack";
    }
}
