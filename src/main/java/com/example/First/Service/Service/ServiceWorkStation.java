package com.example.First.Service.Service;

import com.example.First.ClassEntity.*;
import com.example.First.Wrapper.WorkStationWthDevice;
import com.example.First.repo.ExternalDeviceRepo;
import com.example.First.repo.InformationSystemRepo;
import com.example.First.repo.OperatorRepo;
import com.example.First.repo.WorkStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceWorkStation {
    @Autowired
    private ServiceInfSystem serviceInfSystem;
    @Autowired
    private InformationSystemRepo informationSystemRepo;
    @Autowired
    private OperatorRepo operatorRepo;
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    private ServicePlaceProcessingData servicePlaceProcessingData;
    @Autowired
    private WorkStationRepo workStationRepo;
    @Autowired
    private ExternalDeviceRepo externalDeviceRepo;
    public List<WorkStationWthDevice> getWorkstationWthDevice(int infsysid, int idoperator){
        List<PlaceProccesingData> placeList = servicePlaceProcessingData.getPlaceFromAdresIs(infsysid,idoperator);
        List<WorkStationWthDevice> workStationWthDevices = new ArrayList<WorkStationWthDevice>();
        for(PlaceProccesingData p:placeList){
            for(WorkStation w : workStationRepo.findByplaceProccesingData(p)){
                List<externalDevice> externalDevices = new ArrayList<externalDevice>();
               for(externalDevice e:externalDeviceRepo.findByworkStation(w)){
                   externalDevices.add(e);
               }
                WorkStationWthDevice workStationWthDevice = new WorkStationWthDevice();
                workStationWthDevice.setWorkStation(w);
                workStationWthDevice.setExternaldevice(externalDevices);
                workStationWthDevices.add(workStationWthDevice);
            }

        }
        return workStationWthDevices;
    }
    public WorkStation changeWorkstation(int idworkstation, PlaceProccesingData placeProccesingData){
        WorkStation tmp = workStationRepo.findById((long) idworkstation);
        tmp.setPlaceProccesingData(placeProccesingData);
        workStationRepo.save(tmp);
        return tmp;
    }
    public WorkStation addWorkstation(PlaceProccesingData placeProccesingData,int infsysid,int operatorid){
        WorkStation workStation= new WorkStation();
        workStation.setPlaceProccesingData(placeProccesingData);
        workStationRepo.save(workStation);
        InformationSystem is = informationSystemRepo.findByIdAndOperator((long)infsysid,operatorRepo.findByIdAndUser((long)operatorid,serviceUser.getUser()));
        is.setCountWorkStation(is.getCountWorkStation()+1);
        serviceInfSystem.changeInfSystem(is);
        return workStation;
    }
    public WorkStation deleteWorkstation(int workStationid,int infsysid,int operatorid){
        WorkStation workStation= workStationRepo.findById(workStationid);
        workStationRepo.delete(workStation);
        InformationSystem is = informationSystemRepo.findByIdAndOperator((long)infsysid,operatorRepo.findByIdAndUser((long)operatorid,serviceUser.getUser()));
        is.setCountWorkStation(is.getCountWorkStation()-1);
        serviceInfSystem.changeInfSystem(is);
        return workStation;
    }
}
