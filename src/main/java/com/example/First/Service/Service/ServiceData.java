package com.example.First.Service.Service;

import com.example.First.ClassEntity.OperatorPersData;
import com.example.First.Security.USER;
import com.example.First.repo.InformationSystemRepo;
import com.example.First.repo.OperatorRepo;
import com.example.First.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceData {
    @Autowired
    private OperatorRepo operatorRepo;
    @Autowired
    private InformationSystemRepo infsysRepo;
    @Autowired
    private ServiceUser serviceUser;
    public List<OperatorPersData> getAll() {
        return  operatorRepo.findByUser(serviceUser.getUser());
    }
    public OperatorPersData addNewOperator(OperatorPersData operatorPersData){
        operatorPersData.setId(new OperatorPersData().getId());
        operatorPersData.setUser(serviceUser.getUser());
        operatorRepo.save(operatorPersData);
        return operatorPersData;
    }
    public OperatorPersData getOperatorOnId(int id){
        return  operatorRepo.findByIdAndUser((long)id, serviceUser.getUser());
    }
    /* public OperatorPersData replaceOperator(OperatorPersData operatorPersData){
        operatorRepo.save(operatorPersData);
        return operatorPersData;
    }
   public void deleteOperator(OperatorPersData operatorPersData){
        operatorRepo.deleteById(operatorPersData.getId());
        if(operatorPersData.getId()== ControllerFirst.getOperatorChangeGlob().getId()){
            ControllerFirst.setOperatorChangeGlob(null);
        }

    }
    public OperatorPersData operatorChange(long operatorChange){
        List<OperatorPersData> operat = (List<OperatorPersData>) operatorRepo.findAll();
        Optional<OperatorPersData> opop = operatorRepo.findById(operatorChange);
        ControllerFirst.setOperatorChangeGlob(opop.get());
        return opop.get();

    }
    public InformationSystem infsystemChange(long infsystem){
        Optional<InformationSystem> isop = infsysRepo.findById(infsystem);
        ControllerFirst.setInformationSystemChangeGlob(isop.get());
        return isop.get();
    }
*/
}
