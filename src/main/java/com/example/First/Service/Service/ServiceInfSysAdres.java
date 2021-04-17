package com.example.First.Service.Service;


import com.example.First.ClassEntity.InformationSystem;
import com.example.First.ClassEntity.InformationSystemAdress;
import com.example.First.ClassEntity.OperatorPersData;
import com.example.First.repo.InformationSystemAdresRepo;
import com.example.First.repo.InformationSystemRepo;
import com.example.First.repo.OperatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceInfSysAdres {
    @Autowired
    private InformationSystemAdresRepo informationSystemAdresRepo;
    @Autowired
    private InformationSystemRepo informationSystemRepo;
    @Autowired
    private OperatorRepo operator;
    @Autowired
    private ServiceUser serviceUser;
    public void addInfSysAdresForIS(int infsysId, InformationSystemAdress infad,int operatorId) {
        infad.setId(new InformationSystemAdress().getId());
        infad.setInformationSystem(informationSystemRepo.findByIdAndOperator((long) infsysId,operator.findByIdAndUser((long) operatorId,serviceUser.getUser()).get(0)).get(0));
        informationSystemAdresRepo.save(infad);
    }
    public void changeInfSysAdresForIS(int infsysId,InformationSystemAdress infad,int operatorId) {
        if(informationSystemRepo.findByIdAndOperator((long) infsysId,operator.findByIdAndUser((long) operatorId,serviceUser.getUser()).get(0)).get(0)!=null) {
            informationSystemAdresRepo.save(infad);
        }
    }
    public void deleteInfSysAdresForIS(int infsysId,InformationSystemAdress infad,int operatorId) {
        if(informationSystemRepo.findByIdAndOperator((long) infsysId,operator.findByIdAndUser((long) operatorId,serviceUser.getUser()).get(0)).get(0)!=null) {
            informationSystemAdresRepo.delete(infad);
        }
    }
    public List<InformationSystemAdress> getinfSysAdresFromIS(int infsysId,int operatorId) {
        return informationSystemAdresRepo.findByInformationSystem(informationSystemRepo.findByIdAndOperator((long)infsysId,operator.findByIdAndUser((long) operatorId,serviceUser.getUser()).get(0)).get(0));
    }
}
