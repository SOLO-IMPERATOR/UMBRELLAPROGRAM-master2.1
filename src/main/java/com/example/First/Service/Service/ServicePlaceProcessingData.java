package com.example.First.Service.Service;


import com.example.First.ClassEntity.InformationSystemAdress;
import com.example.First.ClassEntity.PlaceProccesingData;
import com.example.First.repo.InformationSystemAdresRepo;
import com.example.First.repo.InformationSystemRepo;
import com.example.First.repo.OperatorRepo;
import com.example.First.repo.PlaceProcessingDataRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServicePlaceProcessingData {
    @Autowired
    private InformationSystemRepo informationSystemRepo;
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    private OperatorRepo operatorRepo;
    @Autowired
    private PlaceProcessingDataRepo placeProcessingDataRepo;
    @Autowired
    private ServiceInfSysAdres serviceInfSysAdres;
    @Value("${upload.path}")
    private String uploadPath;
    public List<PlaceProccesingData> getPlaceFromAdresIs(int infsysid,int idoperator){
        List<InformationSystemAdress> isadres = serviceInfSysAdres.getinfSysAdresFromIS(infsysid,idoperator);
        List<PlaceProccesingData> result = new ArrayList<PlaceProccesingData>();
        for (InformationSystemAdress k : isadres){
            for(PlaceProccesingData p : placeProcessingDataRepo.findByInformationSystemAdress(k)){
                result.add(p);
            }
        }
        return result;
    }
    public void addPlaceFromAdresIs (PlaceProccesingData placeProcessingData, MultipartFile mp) throws IOException {
        if(mp!=null){
            File uploadFile = new File(uploadPath+"/place/users/"+serviceUser.getUser().getId()+"/");
            if(!uploadFile.exists()){
                uploadFile.mkdirs();
            }
            String uuidFile = UUID.randomUUID().toString();
            String finalfilename = uuidFile+"."+mp.getOriginalFilename();
            mp.transferTo(new File(uploadPath+"/place/users/"+serviceUser.getUser().getId()+"/"+finalfilename));
            placeProcessingData.setId(new PlaceProccesingData().getId());
            placeProcessingData.setImage(uploadPath+"/place/users/"+serviceUser.getUser().getId()+"/"+finalfilename);
            placeProcessingDataRepo.save(placeProcessingData);
        }
    }
    public void changePlaceFromAdresIs(PlaceProccesingData placeProcessingData, MultipartFile mp,String path) throws IOException {
       PlaceProccesingData tmp = placeProcessingDataRepo.findById(placeProcessingData.getId()).get();
        if(!mp.isEmpty()){
                if(tmp.getImage()!=null) {
                    File delFile = new File(tmp.getImage());
                    delFile.delete();
                }
                String uuidFile = UUID.randomUUID().toString();
                String finalfilename = uuidFile+"."+mp.getOriginalFilename();
                mp.transferTo(new File(uploadPath+"/place/users/"+serviceUser.getUser().getId()+"/"+finalfilename));
                placeProcessingData.setImage(uploadPath+"/place/users/"+serviceUser.getUser().getId()+"/"+finalfilename);
                placeProcessingDataRepo.save(placeProcessingData);
            }else {
            placeProcessingData.setImage(tmp.getImage());
            placeProcessingDataRepo.save(placeProcessingData);
        }
    }

    public void deletePlaceFromAdresIs(PlaceProccesingData placeProcessingData){
        PlaceProccesingData tmp = placeProcessingDataRepo.findById(placeProcessingData.getId()).get();
        if(tmp.getImage()!=null) {
            File delFile = new File(tmp.getPlace());
            delFile.delete();
        }
        placeProcessingDataRepo.delete(placeProcessingData);
    }
    public boolean havePlaceFromAdresIs(int infsysid,int idoperator){
        List<InformationSystemAdress> isadres = serviceInfSysAdres.getinfSysAdresFromIS(infsysid,idoperator);
        List<PlaceProccesingData> result = new ArrayList<PlaceProccesingData>();
        for (InformationSystemAdress k : isadres){
            for(PlaceProccesingData p : placeProcessingDataRepo.findByInformationSystemAdress(k)){
                result.add(p);
            }
        }
      if(result.size()>0){
          return true;
      }else{
          return false;
      }
    }
}

