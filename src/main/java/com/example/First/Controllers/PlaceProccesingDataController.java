package com.example.First.Controllers;

import com.example.First.ClassEntity.InformationSystem;
import com.example.First.ClassEntity.PlaceProccesingData;
import com.example.First.Service.Service.ServiceInfSysAdres;
import com.example.First.Service.Service.ServicePlaceProcessingData;
import com.example.First.Service.Service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PlaceProccesingDataController {
    @Autowired
    private ServiceInfSysAdres serviceInfSysAdres;
    @Autowired
    private ServicePlaceProcessingData servicePostProcessingData;

    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/Place", params="getPlace", method = RequestMethod.GET)
    public String getAllPlace(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId)
    {
        model.addAttribute("Place",servicePostProcessingData.getPlaceFromAdresIs(infsysId,idoperatorForis));
        model.addAttribute("AdresesIs",serviceInfSysAdres.getinfSysAdresFromIS(infsysId,idoperatorForis));
        return "placeprocessingdata";
    }


    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/Place", params="addPlace", method = RequestMethod.POST)
    public String addPlace(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId, @ModelAttribute PlaceProccesingData place, @RequestParam ("file") MultipartFile file) throws IOException {
        servicePostProcessingData.addPlaceFromAdresIs(place,file);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/Place?getPlace";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/Place", params="changePlace", method = RequestMethod.POST)
    public String changePlace(Model model,  @ModelAttribute PlaceProccesingData place, @RequestParam ("file") MultipartFile file, @PathVariable int idoperatorForis, @PathVariable int infsysId,@RequestParam String imgpath) throws IOException {
        servicePostProcessingData.changePlaceFromAdresIs(place,file,imgpath);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/Place?getPlace";
    }
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}/Place", params="deletePlace", method = RequestMethod.POST)
    public String deletePlace(Model model, @ModelAttribute PlaceProccesingData place, @PathVariable int idoperatorForis, @PathVariable int infsysId) throws IOException {
        servicePostProcessingData.deletePlaceFromAdresIs(place);
        return "redirect:/data/"+idoperatorForis+"/IS/"+infsysId+"/Place?getPlace";
    }
}
