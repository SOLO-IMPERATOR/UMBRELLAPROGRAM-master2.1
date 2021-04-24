package com.example.First.Controllers;

import com.example.First.ClassEntity.PlaceProccesingData;
import com.example.First.ClassEntity.WorkStation;
import com.example.First.ClassEntity.externalDevice;
import com.example.First.Service.Service.ServiceExternalDevice;
import com.example.First.Service.Service.ServicePlaceProcessingData;
import com.example.First.Service.Service.ServiceWorkStation;
import com.example.First.repo.WorkStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WorkStationController {
    @Autowired
    private ServiceWorkStation serviceWorkStation;
    @Autowired
    private ServicePlaceProcessingData servicePlaceProcessingData;
    @Autowired
    private ServiceExternalDevice serviceExternalDevice;
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/WorkStation", params="getWorkStation", method = RequestMethod.GET)
    public String getAllWsWthDevices(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId)
    {
        model.addAttribute("places",servicePlaceProcessingData.getPlaceFromAdresIs(infsysId,idoperatorForis));
        model.addAttribute("workstations",serviceWorkStation.getWorkstationWthDevice(infsysId,idoperatorForis));
        return "workstation";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/WorkStation", params="addWS", method = RequestMethod.POST)
    public String addWS(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId,@RequestParam(required = false) List<String> typeext, @RequestParam(required = false) List<String> modelnum, @RequestParam(required = false) List<String> serialnum, @RequestParam PlaceProccesingData placeProccesingData)
    {
        WorkStation tmp =serviceWorkStation.addWorkstation(placeProccesingData,infsysId,idoperatorForis);
        if(typeext!=null) {
            serviceExternalDevice.addDeviceToWorkStation(modelnum, serialnum, typeext, tmp);
        }
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/WorkStation?getWorkStation";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/WorkStation", params="changeWS", method = RequestMethod.POST)
    public String changeWS(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId,@RequestParam(required = false) List<String> typeext, @RequestParam(required = false) List<String> modelnum, @RequestParam(required = false) List<String> serialnum, @RequestParam PlaceProccesingData placeProccesingData,@RequestParam int idworkstation,@RequestParam(required = false)List<Long> deviceid, @RequestParam(required = false) List<String> modelnumuse, @RequestParam(required = false) List<String> serialnumuse)
    {
       WorkStation tmp = serviceWorkStation.changeWorkstation(idworkstation,placeProccesingData);
        serviceExternalDevice.changeDeviceToWorkStation(deviceid,modelnumuse,serialnumuse,typeext,modelnum,serialnum,tmp);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/WorkStation?getWorkStation";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/WorkStation", params="deleteWS", method = RequestMethod.POST)
    public String deleteWS(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId,@RequestParam(required = false) List<String> typeext, @RequestParam(required = false) List<String> modelnum, @RequestParam(required = false) List<String> serialnum, @RequestParam PlaceProccesingData placeProccesingData,@RequestParam int idworkstation,@RequestParam(required = false)List<Long> deviceid, @RequestParam(required = false) List<String> modelnumuse, @RequestParam(required = false) List<String> serialnumuse)
    {
        serviceWorkStation.deleteWorkstation(idworkstation,infsysId,idoperatorForis);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/WorkStation?getWorkStation";
    }

}
