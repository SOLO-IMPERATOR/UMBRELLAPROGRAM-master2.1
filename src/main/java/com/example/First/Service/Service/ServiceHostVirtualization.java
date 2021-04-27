package com.example.First.Service.Service;

import com.example.First.ClassEntity.HostVirtualization;
import com.example.First.repo.HostVirtualizationRepo;
import com.example.First.repo.InformationSystemRepo;
import com.example.First.repo.OperatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceHostVirtualization {
    @Autowired
    private HostVirtualizationRepo hostVirtualizationRepo;
    @Autowired
    private InformationSystemRepo informationSystemRepo;
    @Autowired
    private OperatorRepo operator;
    @Autowired
    private ServiceUser service;
    public List<HostVirtualization> getHostVirtualization(int infsysid,int operatorid){
       return hostVirtualizationRepo.findByInformationSystem(informationSystemRepo.findByIdAndOperator((long)infsysid,operator.findByIdAndUser((long)operatorid,service.getUser())));
    }
    public void addHostVirtualization(HostVirtualization host){
        host.setId(new HostVirtualization().getId());
        hostVirtualizationRepo.save(host);
    }
    public void delHostVirtualization(HostVirtualization host){
        hostVirtualizationRepo.delete(host);
    }
}
