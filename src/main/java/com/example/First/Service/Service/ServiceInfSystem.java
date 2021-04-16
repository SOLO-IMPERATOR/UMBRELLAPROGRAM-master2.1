package com.example.First.Service.Service;
import com.example.First.ClassEntity.InformationSystem;
import com.example.First.ClassEntity.OperatorPersData;
import com.example.First.Controllers.ControllerFirst;
import com.example.First.repo.InformationSystemRepo;
import com.example.First.repo.OperatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceInfSystem {
    @Autowired
    private InformationSystemRepo informationSystemRepo;
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    OperatorRepo operatorRepo;
    public List<InformationSystem> getInfSysFromOperator(int operatorid) {
      return informationSystemRepo.findByOperator(operatorRepo.findByIdAndUser((long)operatorid,serviceUser.getUser()).get(0));
    }
    public void addNewInfSystem(InformationSystem informationSystem){
        informationSystem.setId(new InformationSystem().getId());
        informationSystemRepo.save(informationSystem);
    }
 public List<InformationSystem> getOperatorOnId(int id,int operatorid){
        return informationSystemRepo.findByIdAndOperator((long)id,operatorRepo.findByIdAndUser((long)operatorid,serviceUser.getUser()).get(0));
    }
     /*  public void addNewInfSystem(InformationSystem informationSystem){
        informationSystem.setId(new InformationSystem().getId());
        informationSystem.setUserId(serviceUser.getUserId());
        informationSystemRepo.save(informationSystem);
    }*/
    /*
    public void replaceInfSystem(InformationSystem informationSystem){
        informationSystemRepo.save(informationSystem);
    }
    public void deleteInfSystem(InformationSystem informationSystem){
        informationSystemRepo.deleteById(informationSystem.getId());
        if (ControllerFirst.getInformationSystemChangeGlob().getId()==informationSystem.getId()){
            ControllerFirst.setInformationSystemChangeGlob(null);
        }
    }
    */

}

