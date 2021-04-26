package com.example.First.Controllers;

import com.example.First.Service.Service.ServiceInfSysAdres;
import com.example.First.Service.Service.ServicePlaceProcessingData;
import com.example.First.Service.Service.ServiceServerRack;
import groovy.lang.Grab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Grab("org.webjars:jquery:2.0.3-1")

@Controller
public class AllDataConrtoller {
    @Autowired
    private ServiceInfSysAdres serviceInfSysAdres;
    @Autowired
    private ServicePlaceProcessingData servicePlaceProcessingData;
    @Autowired
    private ServiceServerRack serviceServerRack;
    @RequestMapping(value = "data/{idoperatorForis}/IS/{infsysId}", params="getAllData", method = RequestMethod.GET)
    public String getAllOperator(Model model, @PathVariable int idoperatorForis, @PathVariable int infsysId)
    {
        model.addAttribute("haveAdresIs",serviceInfSysAdres.haveInfSysAdresForIS(infsysId,idoperatorForis));
        model.addAttribute("havePlace",servicePlaceProcessingData.havePlaceFromAdresIs(infsysId,idoperatorForis));
        model.addAttribute("haveServerRack",serviceServerRack.haveServerRack(infsysId,idoperatorForis));

        return "AllDataIs";
    }
}
