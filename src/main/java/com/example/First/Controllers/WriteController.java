package com.example.First.Controllers;
/*
import com.example.First.Service.Service.ServiceDocuments;
import com.example.First.Service.Service.ServiceOtvFace;
import com.example.First.Service.Service.Write;
import groovy.lang.Grab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Grab("org.webjars:jquery:2.0.3-1")

@Controller
public class WriteController  {

    @Autowired
    ServiceDocuments documents;
    @Autowired
    ServiceOtvFace serviceOtvFace;
    @Autowired
    Write write;
    @RequestMapping(value = "/greeting",params = "write")
    public String OneFormOtvetFaceCreate(Model model) {
        return "greeting";
    }
    @RequestMapping(value = "/greeting", params = "sendwrite", method = RequestMethod.POST)
    public String sendOperator(Model model, HttpServletRequest request) throws Exception {

        write.setDoс(1);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("%FULLNAMEORGANIZATION%","HE::");
        write.replace(hashMap);
        return "greeting";
    }

    @RequestMapping(value = "/greeting", params = "GetDocuments")
    public String OneFormOperatorCreate(Model model) {
        model.addAttribute("listdoc", documents.getAll());
        return "greeting";
    }
    @RequestMapping(value = "/greeting", params = "sendWrite")
    public String SaveOrWrite(@RequestParam long id) {
        System.out.println(id);
        return "redirect:/greeting?GetDocuments";
    }

}
*/