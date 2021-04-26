package com.example.First.Service.Service;

import com.example.First.ClassEntity.PlaceProccesingData;
import com.example.First.ClassEntity.ServerRack;
import com.example.First.repo.ServerRackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceServerRack {
    @Autowired
    private ServerRackRepo serverRackRepo;
    @Autowired
    private ServicePlaceProcessingData servicePlaceProcessingData;
    public List<ServerRack> getServerRack(int infsysid,int operatorid){
       List<PlaceProccesingData> tmp =  servicePlaceProcessingData.getPlaceFromAdresIs(infsysid,operatorid);
       List<ServerRack> result = new ArrayList<>();
       for(PlaceProccesingData p:tmp){
           for(ServerRack s : serverRackRepo.findByplaceProccesingData(p)){
               result.add(s);
           }
       }
       return result;
    }
    public void addServerRack(ServerRack serverRack){
        serverRack.setId(new ServerRack().getId());
        serverRackRepo.save(serverRack);

    }
    public void deleteServerRack(ServerRack serverRack){
        serverRackRepo.delete(serverRack);
    }
    public void changeServerRack(ServerRack serverRack){
        serverRackRepo.save(serverRack);
    }
    public boolean haveServerRack(int infsysid,int operatorid){
        List<PlaceProccesingData> tmp =  servicePlaceProcessingData.getPlaceFromAdresIs(infsysid,operatorid);
        List<ServerRack> result = new ArrayList<>();
        for(PlaceProccesingData p:tmp){
            for(ServerRack s : serverRackRepo.findByplaceProccesingData(p)){
                result.add(s);
            }
        }
        if(result.size()>0){
            return true;
        }else {
            return false;
        }
    }
}
