package com.example.First.Controllers;

import com.example.First.ClassEntity.ServerDevices;
import com.example.First.Service.Service.ServiceServerDevices;
import com.example.First.Service.Service.ServiceServerRack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServerDevicesController {
    @Autowired
    private ServiceServerRack serviceServerRack;
    @Autowired
    private ServiceServerDevices serviceServerDevices;
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/ServerDevices", params="getDevices", method = RequestMethod.GET)
    public String getDevices(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId)
    {
        model.addAttribute("serverRack",serviceServerRack.getServerRack(infsysId,idoperatorForis));
        model.addAttribute("serverdevices",serviceServerDevices.getServerDevices(infsysId,idoperatorForis));
        return "serverdevice";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/ServerDevices", params="addDevice", method = RequestMethod.POST)
    public String addDevices(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute ServerDevices serverDevices)
    {
        serviceServerDevices.addServerDevices(serverDevices);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/ServerDevices?getDevices";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/ServerDevices", params="changeDevice", method = RequestMethod.POST)
    public String changeDevices(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute ServerDevices serverDevices)
    {
        serviceServerDevices.changeServerDevices(serverDevices);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/ServerDevices?getDevices";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/ServerDevices", params="delDevice", method = RequestMethod.POST)
    public String delDevices(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute ServerDevices serverDevices)
    {
        System.out.println("helooooooooooooooooooooooooooooooooo");
        serviceServerDevices.delServerDevices(serverDevices);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/ServerDevices?getDevices";
    }
}
