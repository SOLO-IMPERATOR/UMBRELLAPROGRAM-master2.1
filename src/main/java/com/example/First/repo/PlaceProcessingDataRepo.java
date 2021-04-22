package com.example.First.repo;

import com.example.First.ClassEntity.InformationSystemAdress;
import com.example.First.ClassEntity.PlaceProccesingData;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface PlaceProcessingDataRepo extends CrudRepository<PlaceProccesingData,Long> {
    List<PlaceProccesingData> findByInformationSystemAdress(InformationSystemAdress informationSystemAdress);
    Optional<PlaceProccesingData> findById(Long id);
}
