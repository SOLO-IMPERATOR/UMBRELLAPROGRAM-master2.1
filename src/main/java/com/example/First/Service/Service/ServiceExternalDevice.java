package com.example.First.Service.Service;

import com.example.First.ClassEntity.WorkStation;
import com.example.First.ClassEntity.externalDevice;
import com.example.First.repo.ExternalDeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceExternalDevice{
    @Autowired
    private ExternalDeviceRepo externalDeviceRepo;
    public void addDeviceToWorkStation(List<String> model, List<String> serial, List<String>type, WorkStation workStation){
        for(int i=0;i<type.size();i++){
            externalDevice externalDevice = new externalDevice();
            externalDevice.setModel(model.get(i));
            externalDevice.setName(type.get(i));
            externalDevice.setSerialNumber(serial.get(i));
            externalDevice.setWorkStation(workStation);
            externalDeviceRepo.save(externalDevice);
        }
    }
    public void changeDeviceToWorkStation(List<Long> id,List<String> modeluse, List<String> serialuse, List<String>type,List<String> model, List<String> serial, WorkStation workStation){
                List<externalDevice> deviceFromWorkStation = externalDeviceRepo.findByworkStation(workStation);

        if(id!=null) {
            for (externalDevice e : deviceFromWorkStation) {
                boolean isHave = false;
                for (int i = 0; i < id.size(); i++) {
                    externalDevice tmp = externalDeviceRepo.findById(id.get(i)).get();
                    if (tmp.getId() == e.getId()) {
                        isHave = true;
                    }
                }
                if (!isHave) {
                    externalDeviceRepo.delete(e);
                }
            }

            for (int i = 0; i < id.size(); i++) {
                externalDevice tmp = externalDeviceRepo.findById(id.get(i)).get();
                tmp.setModel(modeluse.get(i));
                tmp.setSerialNumber(serialuse.get(i));
                externalDeviceRepo.save(tmp);
            }
        }else{
            externalDeviceRepo.deleteAll(deviceFromWorkStation);
        }
       if(type!=null) {
           for (int i = 0; i < type.size(); i++) {
               externalDevice externalDevice = new externalDevice();
               externalDevice.setModel(model.get(i));
               externalDevice.setName(type.get(i));
               externalDevice.setSerialNumber(serial.get(i));
               externalDevice.setWorkStation(workStation);
               externalDeviceRepo.save(externalDevice);
           }
       }
    }

}
