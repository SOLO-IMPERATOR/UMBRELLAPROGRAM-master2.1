package com.example.First.Controllers;


import com.example.First.ClassEntity.InformationSystem;
import com.example.First.ClassEntity.OperatorPersData;
import com.example.First.repo.InformationSystemRepo;
import com.example.First.repo.OperatorRepo;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


public class ControllerFirst {
   /* @Autowired
    private OperatorRepo operatorRepo;

    @Autowired
    private  InformationSystemRepo infSysRepo;




    private OperatorPersData operpred;

    public static void setOperatorChangeGlob(OperatorPersData operatorChangeGlob) {
        ControllerFirst.operatorChangeGlob = operatorChangeGlob;
    }

    public static void setInformationSystemChangeGlob(InformationSystem informationSystemChangeGlob) {
        ControllerFirst.informationSystemChangeGlob = informationSystemChangeGlob;
    }

    private static OperatorPersData operatorChangeGlob;
    private  static InformationSystem informationSystemChangeGlob;

    public static OperatorPersData getOperatorChangeGlob() {
        return operatorChangeGlob;
    }

    public static InformationSystem getInformationSystemChangeGlob() {
        return informationSystemChangeGlob;
    }



@ModelAttribute
    public void changeInfSystemAndOperator(Model model){

            List<OperatorPersData> operator = (List<OperatorPersData>) operatorRepo.findAll();
            if (operatorChangeGlob == null) {
                operatorChangeGlob = operator.get(operator.size() - 1);

                operpred = operatorChangeGlob;
            }
            Optional<OperatorPersData> as = operatorRepo.findById(operatorChangeGlob.getId());
            if(!as.get().getShortname().equalsIgnoreCase(operatorChangeGlob.getShortname())){
                operatorChangeGlob=as.get();
            }


            List<InformationSystem> is;
            try {
                is = (ArrayList<InformationSystem>) infSysRepo.findAll();
                List<InformationSystem> ischange = is.stream().filter(a -> Objects.equals(a.getOperatorid(), (int) operatorChangeGlob.getId())).collect(Collectors.toList());
                if (operpred != operatorChangeGlob || informationSystemChangeGlob == null) {
                    operpred = operatorChangeGlob;
                    informationSystemChangeGlob = ischange.get(ischange.size() - 1);
                }
            }catch (Exception e){
                is=null;
                informationSystemChangeGlob = null;
            }

            model.addAttribute("listoperator", operator);
            model.addAttribute("listinfsystem", is);
            model.addAttribute("operatorChange",operatorChangeGlob);
            model.addAttribute("infSystemChange",informationSystemChangeGlob);




    }*/
}
