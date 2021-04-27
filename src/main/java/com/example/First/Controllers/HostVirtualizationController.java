package com.example.First.Controllers;


import com.example.First.ClassEntity.HostVirtualization;
import com.example.First.ClassEntity.InformationSystemAdress;
import com.example.First.ClassEntity.ServerDevices;
import com.example.First.Service.Service.ServiceHostVirtualization;
import com.example.First.Service.Service.ServiceInfSysAdres;
import com.example.First.Service.Service.ServiceServerDevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HostVirtualizationController {

    @Autowired
    private ServiceHostVirtualization serviceHostVirtualization;
    @Autowired
    private ServiceServerDevices serviceServerDevices;

    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/HostVirtual",params = "getHosts",method = RequestMethod.GET)
    public String getHosts(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId) {
        model.addAttribute("informationSystem",infsysId);
        model.addAttribute("servers",serviceServerDevices.getServerDevices(infsysId,idoperatorForis));
        model.addAttribute("hostsvirt",serviceHostVirtualization.getHostVirtualization(infsysId,idoperatorForis));
        return "hostvirtualization";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/HostVirtual",params = "addHost",method = RequestMethod.POST)
    public String addHost(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute HostVirtualization hostVirtualization) {
        serviceHostVirtualization.addHostVirtualization(hostVirtualization);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/HostVirtual?getHosts";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/HostVirtual",params = "delHost",method = RequestMethod.POST)
    public String delHost(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute HostVirtualization hostVirtualization) {
        serviceHostVirtualization.delHostVirtualization(hostVirtualization);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/HostVirtual?getHosts";
    }
}
