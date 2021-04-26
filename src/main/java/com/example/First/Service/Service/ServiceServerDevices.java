package com.example.First.Service.Service;

import com.example.First.ClassEntity.ServerDevices;
import com.example.First.ClassEntity.ServerRack;
import com.example.First.repo.ServerDevicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceServerDevices {
@Autowired
private ServerDevicesRepo serverDevicesRepo;
@Autowired
private ServiceServerRack serviceServerRack;
    public List<ServerDevices> getServerDevices(int infsysId,int operatorid){
        List<ServerDevices> result = new ArrayList<ServerDevices>();
        for(ServerRack s : serviceServerRack.getServerRack(infsysId,operatorid))
            for(ServerDevices d : serverDevicesRepo.findByserverRack(s)){
                result.add(d);
            }
        return  result;
    }
    public void addServerDevices(ServerDevices serverDevice){
        serverDevice.setId(new ServerDevices().getId());
        serverDevicesRepo.save(serverDevice);
    }
    public void changeServerDevices(ServerDevices serverDevice){
        serverDevicesRepo.save(serverDevice);
    }
    public void delServerDevices(ServerDevices serverDevice){
        serverDevicesRepo.delete(serverDevice);
        System.out.println("deleeeteeeeeeeeeeeeee");
    }
}
